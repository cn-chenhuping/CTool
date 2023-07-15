package com.chen.wx.pay;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.chen.config.wxconfig.WxAppPayConfig;
import com.wechat.pay.java.service.payments.app.model.*;
import com.wechat.pay.java.core.util.AesUtil;
import com.wechat.pay.java.core.notification.Notification;
import com.wechat.pay.java.service.payments.app.AppServiceExtension;
import com.wechat.pay.java.service.payments.model.Transaction;
import com.wechat.pay.java.service.transferbatch.TransferBatchService;
import com.wechat.pay.java.service.transferbatch.model.BalanceWithdrawal;
import com.wechat.pay.java.service.transferbatch.model.InitiateBatchTransferRequest;
import com.wechat.pay.java.service.transferbatch.model.InitiateBatchTransferResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信APP支付封装
 * chenhuping
 * 2023-06-17
 */
@Slf4j
public class WxAppPay {
    @Resource
    AppServiceExtension appServiceExtension;
    @Resource
    WxAppPayConfig wxAppPayConfig;
    @Resource
    TransferBatchService transferBatchService;

    /**
     * APP下单
     * @param request
     * @return
     */
    public com.wechat.pay.java.service.payments.app.model.PrepayWithRequestPaymentResponse appPay(PrepayRequest request){
        PrepayWithRequestPaymentResponse prepay = appServiceExtension.prepayWithRequestPayment(request);
        return prepay;
    }

    /**
     * 微信支付回调
     * @param request
     * @return
     * @throws Exception 返回解密后的对象，可以根据对象中的状态进行业务处理
     */
    public Transaction wxNotify(HttpServletRequest request) throws Exception {
        log.info("-------微信回调-------");
        // 从请求体中获取原始报文
        StringBuilder requestBody = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        String body = requestBody.toString();
        Notification notification = JSONObject.parseObject(body, Notification.class);
        log.info("微信回调转换后的报文：" + notification);

        AesUtil aesUtil = new AesUtil(wxAppPayConfig.getV3Key().getBytes());
        com.wechat.pay.java.core.notification.Resource resource = notification.getResource();
        String decrypt = aesUtil.decryptToString(resource.getAssociatedData().getBytes(), resource.getNonce().getBytes(), resource.getCiphertext());

        // 以支付通知回调为例，验签、解密并转换成 Transaction
        Transaction transaction = JSONObject.parseObject(decrypt, Transaction.class);
        log.info("微信回调验签解密成功："+ transaction);
        return transaction;
    }

    /**
     * 查询订单
     * @param wxOrderQueryParams 查询订单请求参数，可根据商户订单号和微信订单号查询
     * @return 查询结果
     * @throws Exception
     */
    public Map<String, String> wxOrderQuery(WxOrderQueryParams wxOrderQueryParams) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        try {
            Transaction transaction = new Transaction();
            // 构建查询订单的请求参数
            if (Strings.isNotBlank(wxOrderQueryParams.getTransaction_id())) {
                com.wechat.pay.java.service.payments.app.model.QueryOrderByIdRequest queryOrderByIdRequest = new QueryOrderByIdRequest();
                queryOrderByIdRequest.setMchid(wxOrderQueryParams.getMch_id());
                queryOrderByIdRequest.setTransactionId(wxOrderQueryParams.getTransaction_id());
                transaction = appServiceExtension.queryOrderById(queryOrderByIdRequest);
            } else {
                QueryOrderByOutTradeNoRequest queryOrderByOutTradeNoRequest = new QueryOrderByOutTradeNoRequest();
                queryOrderByOutTradeNoRequest.setMchid(wxOrderQueryParams.getMch_id());
                queryOrderByOutTradeNoRequest.setOutTradeNo(wxOrderQueryParams.getOut_trade_no());
                transaction = appServiceExtension.queryOrderByOutTradeNo(queryOrderByOutTradeNoRequest);
            }
            String tradeState = transaction.getTradeState().name();

            // 查询成功，根据tradeState来判断订单状态
            if ("SUCCESS".equals(tradeState)) {
                // 订单支付成功
                map.put("code", "SUCCESS");
                map.put("message", "支付成功");
            } else if ("NOTPAY".equals(tradeState)) {
                // 订单未支付
                map.put("code", "ERROR");
                map.put("message", "订单未支付");
            } else if ("CLOSED".equals(tradeState)) {
                // 订单已关闭
                map.put("code", "ERROR");
                map.put("message", "订单已关闭");
            } else if("REFUND".equals(tradeState)){
                // 转入退款
                map.put("code", "REFUND");
                map.put("message", "转入退款");
            }else if("REVOKED".equals(tradeState)){
                // 已撤销
                map.put("code", "REVOKED");
                map.put("message", "已撤销");
            }else if("USERPAYING".equals(tradeState)){
                // 用户支付中
                map.put("code", "USERPAYING");
                map.put("message", "用户支付中");
            }else if("PAYERROR".equals(tradeState)){
                // 支付失败
                map.put("code", "PAYERROR");
                map.put("message", "支付失败");
            }
            map.put("data", JSON.toJSONString(transaction));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return map;
    }

    /**
     * 商家发起转账零钱，一般用于提现
     * @param balanceWithdrawal 提现请求参数
     * @return
     */
    public InitiateBatchTransferResponse initiateMerchantTransfer(BalanceWithdrawal balanceWithdrawal){
        InitiateBatchTransferRequest request = new InitiateBatchTransferRequest();
        request.setAppid(wxAppPayConfig.getAppid());
        request.setBatchName(balanceWithdrawal.getBatchName());
        request.setBatchRemark(balanceWithdrawal.getBatchRemark());
        request.setOutBatchNo(balanceWithdrawal.getOutBatchNo());
        request.setTransferDetailList(balanceWithdrawal.getTransferDetailList());
        request.setTotalAmount(balanceWithdrawal.getTotalAmount());
        request.setTotalNum(balanceWithdrawal.getTotalNum());
        request.setTransferSceneId(balanceWithdrawal.getTransferSceneId());
        //发起商家转账零钱
        InitiateBatchTransferResponse transfer = transferBatchService.initiateBatchTransfer(request);
        return transfer;
    }
}
