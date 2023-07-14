package com.chen.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 微信支付配置类
 *
 * @author chenhuping
 */
@ConfigurationProperties(prefix = "wx.app.pay")
public class WxAppPayConfig {
    /**
     * 应用APPID
     */
    private String appid;

    /**
     *  appSecret
     */
    private String appSecret;

    /**
     * 商户号
     */
    private String mchid;

    /**
     * v2密钥
     */
    private String v2Key;

    /**
     * v3密钥
     */
    private String v3Key;

    /**
     * 异步回调地址，需要外网可以访问的，微信支付完成后由微信调用
     */
    private String notifyURL;

    /**
     * 商户私钥路径
     */
    private String privateKeyPath;

    /**
     * 微信支付证书路径
     */
    private String certPath;

    /**
     * 商户证书序列号
     */
    private String merchantSerialNumber;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getV2Key() {
        return v2Key;
    }

    public void setV2Key(String v2Key) {
        this.v2Key = v2Key;
    }

    public String getV3Key() {
        return v3Key;
    }

    public void setV3Key(String v3Key) {
        this.v3Key = v3Key;
    }

    public String getNotifyURL() {
        return notifyURL;
    }

    public void setNotifyURL(String notifyURL) {
        this.notifyURL = notifyURL;
    }

    public String getPrivateKeyPath() {
        return privateKeyPath;
    }

    public void setPrivateKeyPath(String privateKeyPath) {
        this.privateKeyPath = privateKeyPath;
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public String getMerchantSerialNumber() {
        return merchantSerialNumber;
    }

    public void setMerchantSerialNumber(String merchantSerialNumber) {
        this.merchantSerialNumber = merchantSerialNumber;
    }
}
