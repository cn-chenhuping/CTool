package com.chen.aliyun.shorts;

import com.chen.aliyun.shorts.model.ShortConfig;
import com.chen.utils.ValidateCodeUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

import static com.chen.aliyun.shorts.model.ShortsEnum.CAPTCHA;

/**
 * 阿里云短信服务封装
 * chenhuping
 * 2023-06-20
 */
@EnableConfigurationProperties(ShortConfig.class)
public class ShortApi {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private ShortConfig shortConfig;

    /**
     * 发送短信，不带STS鉴权
     * @param phone 接收信息的手机号
     * @return
     * @throws Exception
     */
    public String verificationCode(String phone) throws Exception {
        // 请确保代码运行环境设置了环境变量 ALIBABA_CLOUD_ACCESS_KEY_ID 和 ALIBABA_CLOUD_ACCESS_KEY_SECRET。
        // 工程代码泄露可能会导致 AccessKey 泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考，建议使用更安全的 STS 方式，
        // 更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html
        com.aliyun.dysmsapi20170525.Client client = createClient(shortConfig.getAccessKeyId(), shortConfig.getAccessKeySecret());
        String code = ValidateCodeUtils.generateValidateCode(4).toString();
        stringRedisTemplate.opsForValue().set(CAPTCHA + ":" + phone, code, 3, TimeUnit.MINUTES);
        com.aliyun.dysmsapi20170525.models.SendSmsRequest sendSmsRequest = new com.aliyun.dysmsapi20170525.models.SendSmsRequest()
                .setPhoneNumbers(shortConfig.getPhoneNumbers())
                .setSignName(shortConfig.getSignName())
                .setTemplateCode(shortConfig.getTemplateCode())
                .setTemplateParam("{\"code\":\""+code+"\"}")
                .setSmsUpExtendCode(shortConfig.getSmsUpExtendCode());
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        com.aliyun.dysmsapi20170525.models.SendSmsResponse resp = client.sendSmsWithOptions(sendSmsRequest, runtime);
        com.aliyun.teaconsole.Client.log(com.aliyun.teautil.Common.toJSONString(resp));

        // 检查短信发送状态
        if ("OK".equals(resp.getBody().getCode())) {
            return resp.getBody().getMessage() + " 验证码:" + code;
        }
        return "短信发送失败，原因：" + resp.getBody().getMessage();
    }

    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                // 必填，您的 AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 必填，您的 AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }
}
