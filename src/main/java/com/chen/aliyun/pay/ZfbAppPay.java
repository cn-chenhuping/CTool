package com.chen.aliyun.pay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayFundTransToaccountTransferModel;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.chen.config.AlipayConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.rmi.ServerException;
import java.util.*;

/**
 * 支付宝APP支付类
 *
 * @author chenhuping
 */
@Slf4j
public class ZfbAppPay {

    @Autowired
    private AlipayConfig alipayConfig;

    /**
     * 统一下单请求数据封装
     * @param orderNo 订单号
     * @param actualAmount 支付金额
     * @return 封装后的数据可直接下单
     */
    public AlipayTradeAppPayRequest unifiedOrderDataEncapsulation(String orderNo,String actualAmount){
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody(alipayConfig.getBody());
        model.setSubject(alipayConfig.getSubject());
        model.setOutTradeNo(orderNo);//订单号
        model.setTotalAmount(actualAmount);// 支付金额
        model.setTimeoutExpress(alipayConfig.getTimeoutExpress());//支付超时时间
        request.setBizModel(model);
        // 回调地址(充值订单)
        request.setNotifyUrl(alipayConfig.getNotifyUrl());// 回调地址
        return request;
    }

    /**
     * 支付宝APP统一下单
     * @param request 请求下单数据
     * @return
     */
    public Map<String, Object> alibabaUnifiedOrder(AlipayTradeAppPayRequest request) {
        Map<String, Object> map = new HashMap<>();
        //支付宝需要的参数serverUrl、appId、private_key、format、charset、public_key、signType
        AlipayClient alipayClient = new DefaultAlipayClient(
                alipayConfig.getUrl(),
                alipayConfig.getAppId(),
                alipayConfig.getPrivateKey(),
                alipayConfig.getFormat(),
                alipayConfig.getCharset(),
                alipayConfig.getPublicKey(),
                alipayConfig.getSignType());

        //这里和普通的接口调用不同，使用的是sdkExecute
        AlipayTradeAppPayResponse response = null;
        try {
            response = alipayClient.sdkExecute(request);
            map.put("code", "ok");
            map.put("msg", "success");
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("payPath", response.getBody());
            map.put("data", dataMap);
            return map;
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        map.put("code", "400");
        map.put("msg", "success");
        return map;
    }

    /**
     * 支付宝支付回调
     * @param request
     * @return
     */
    public String notifyCallBack(HttpServletRequest request) {
        log.info("--------------支付宝开始回调------------");
        Map<String, String> params = new HashMap<String, String>();
        //从支付宝回调的request域中取值
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);
        }
        //商品订单号
        String out_trade_no = request.getParameter("out_trade_no");
        // 当前交易状态
        String tradeStatus = request.getParameter("trade_status");
        // 支付金额
        String totalAmount = request.getParameter("total_amount");
        // 支付时间
        String payDate = request.getParameter("gmt_payment");
        //3.签名验证(对支付宝返回的数据验证，确定是支付宝返回的)
        boolean signVerified = false;
        try {
            //3.1调用SDK验证签名
            signVerified = AlipaySignature.rsaCheckV1(
                    params,
                    alipayConfig.getPublicKey(),
                    alipayConfig.getCharset(),
                    alipayConfig.getSignType());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        //返回状态存入redis中
        //对验签进行处理
        if (signVerified) {
            //验签通过
            if (tradeStatus.equals("TRADE_SUCCESS")) {
                //支付成功后的业务处理
                return "success";
            }
        } else {  //验签不通过
            log.error("【支付宝回调】订单号："+out_trade_no+"，验签失败");
            return "failure";
        }
        return "failure";
    }

    /**
     * 证书模式 初始化证书文件
     *
     * @param basePath
     * @return
     * @throws ServerException
     */
    private String initCart(String basePath) throws ServerException {
        if (basePath.contains("jar!")) {
            if (basePath.startsWith("file:")) {
                basePath = basePath.replace("file:", "");
            }
            String appCertPath = alipayConfig.getAppCertPath();
            this.checkAndcopyCart(basePath, appCertPath);
            String alipayCertPath = alipayConfig.getAliPayCertPath();
            this.checkAndcopyCart(basePath, alipayCertPath);
            String alipayRootCertPath = alipayConfig.getAliPayRootCertPath();
            this.checkAndcopyCart(basePath, alipayRootCertPath);
        }
        return basePath;
    }

    /**
     * 证书模式下需要
     *
     * @param basePath
     * @param path
     * @throws ServerException
     * @description 查找在该文件路径下是否已经存在这个文件，如果不存在，则拷贝文件
     */
    private void checkAndcopyCart(String basePath, String path) throws ServerException {
        InputStream cartInputStream = null;
        OutputStream cartOutputStream = null;
        String cartPath = basePath + path;
        File cartFile = new File(cartPath);
        File parentFile = cartFile.getParentFile();
        parentFile.mkdirs();
        try {
            if (!cartFile.exists()) {
                cartInputStream = ClassUtils.getDefaultClassLoader().getResourceAsStream(path);
                cartOutputStream = new FileOutputStream(cartFile);
                byte[] buf = new byte[1024];
                int bytesRead;
                while ((bytesRead = cartInputStream.read(buf)) != -1) {
                    cartOutputStream.write(buf, 0, bytesRead);
                }
                cartInputStream.close();
                cartOutputStream.close();
            }
        } catch (IOException e) {
            throw new ServerException(e.getMessage());
        }
    }

    /**
     * 证书模式   获取文件路径
     *
     * @return
     * @throws FileNotFoundException
     * @throws ServerException
     */
    public String queryPath() throws FileNotFoundException, ServerException {
        String basePath = ResourceUtils.getURL("classpath:").getPath();
        basePath = this.initCart(basePath);
        return basePath;
    }

    /**
     * 支付宝提现 测试版
     *
     * @param wOrderNumber 自定义订单号
     * @param amount       提现金额
     * @param
     * @param name         真实姓名
     * @param zfbName      支付宝账户
     * @param operator     操作员
     * @throws Exception
     */
    public String alipayWithdraw(String wOrderNumber, Double amount,  String name, String zfbName, String operator,Integer type) throws ServerException, FileNotFoundException, AlipayApiException {
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        String basePath = this.queryPath();
        //构造client
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        // 设置网关地址
        certAlipayRequest.setServerUrl(alipayConfig.getUrl());
        //设置应用AppId
        certAlipayRequest.setAppId(alipayConfig.getAppId());
        //设置应用私钥
        certAlipayRequest.setPrivateKey(alipayConfig.getPrivateKey());
        // 设置请求格式，固定值json
        certAlipayRequest.setFormat(alipayConfig.getFormat());
        // 设置字符集
        certAlipayRequest.setCharset(alipayConfig.getCharset());
        // 设置签名类型
        certAlipayRequest.setSignType(alipayConfig.getSignType());
        // 设置应用公钥证书路径
        certAlipayRequest.setCertPath(basePath + alipayConfig.getAliPayCertPath());
        // 设置支付宝公钥证书路径
        certAlipayRequest.setAlipayPublicCertPath(basePath + alipayConfig.getAliPayCertPath());
        // 设置支付宝根证书路径
        certAlipayRequest.setRootCertPath(basePath + alipayConfig.getAliPayCertPath());
        // 构造client
        AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
        //请求对象
        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
        // 设置请求参数
        AlipayFundTransToaccountTransferModel model = new AlipayFundTransToaccountTransferModel();
        // 金额
        model.setAmount(String.valueOf(amount));
        // 商户单号  订单id
        model.setOutBizNo(wOrderNumber);
        // 收款方支付宝账号
        model.setPayeeAccount(zfbName);
        // 收款方姓名
        model.setPayeeRealName(name);
        // 收款方账户类型
        model.setPayeeType("ALIPAY_LOGONID");
        // 备注
        model.setRemark("用户提现");
        // 设置请求参数
        request.setBizModel(model);
        AlipayFundTransToaccountTransferResponse response = null;
        try {
            response = alipayClient.certificateExecute(request);
            if (response.isSuccess()) {
                if ("10000".equals(response.getCode())) {
                    log.debug("支付宝转账成功,订单号："+ wOrderNumber);
                    return "success";
                }
            }
        } catch (AlipayApiException e) {
            log.error("支付宝转账失败,订单号："+ wOrderNumber);
            return "error";
        }
        return "error";
    }

}
