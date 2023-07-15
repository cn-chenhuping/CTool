package com.chen.config.wxconfig;

import com.wechat.pay.java.core.RSAConfig;
import com.wechat.pay.java.service.payments.app.AppServiceExtension;
import com.wechat.pay.java.service.transferbatch.TransferBatchService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微信支付自动初始化配置类
 *
 * @author chenhuping
 */
@Configuration
@EnableConfigurationProperties(WxAppPayConfig.class)
public class WchatAutoConfiguration {

    @Bean
    public AppServiceExtension appServiceExtension(WxAppPayConfig wxAppPayConfig){
        // 初始化商户配置
        RSAConfig config =
                new RSAConfig.Builder()
                        .merchantId(wxAppPayConfig.getMchid())
                        // 使用 com.wechat.pay.java.core.util 中的函数从本地文件中加载商户私钥，商户私钥会用来生成请求的签名
                        .privateKeyFromPath(wxAppPayConfig.getPrivateKeyPath())
                        .merchantSerialNumber(wxAppPayConfig.getMerchantSerialNumber())
                        .wechatPayCertificatesFromPath(wxAppPayConfig.getCertPath())
                        .build();
        // 初始化服务
        return new AppServiceExtension.Builder().config(config).build();
    }

    @Bean
    public TransferBatchService transferBatchService(WxAppPayConfig wxAppPayConfig){
        // 初始化商户配置
        RSAConfig config =
                new RSAConfig.Builder()
                        .merchantId(wxAppPayConfig.getMchid())
                        // 使用 com.wechat.pay.java.core.util 中的函数从本地文件中加载商户私钥，商户私钥会用来生成请求的签名
                        .privateKeyFromPath(wxAppPayConfig.getPrivateKeyPath())
                        .merchantSerialNumber(wxAppPayConfig.getMerchantSerialNumber())
                        .wechatPayCertificatesFromPath(wxAppPayConfig.getCertPath())
                        .build();
        // 初始化服务
        return new TransferBatchService.Builder().config(config).build();
    }

    @Bean
    public WxAppPayConfig wxAppPayConfig(){
        return new WxAppPayConfig();
    }

}
