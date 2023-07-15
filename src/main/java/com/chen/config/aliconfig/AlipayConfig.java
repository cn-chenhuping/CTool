package com.chen.config.aliconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 支付宝支付配置类
 *
 * @author chenhuping
 */
@Configuration
@ConfigurationProperties(prefix = "aliyun.app.pay")
public class AlipayConfig {

    /**
     * 应用公钥证书路径
     */
    private String appCertPath;

    /**
     * 支付宝公钥证书路径
     */
    private String aliPayCertPath;

    /**
     * 支付宝根证书路径
     */
    private String aliPayRootCertPath;

    /**
     * APPID
     */
    private String appId;

    /**
     * 生成公钥时对应的私钥
     */
    private String privateKey;

    /**
     * 异步回调接口:得放到服务器上，且使用域名解析 IP
     */
    private String notifyUrl;


    /**
     * 支付宝网关（注意沙箱alipaydev，正式则为 alipay）
     */
    private String url;

    /**
     * 编码类型
     */
    private String charset = "UTF-8";

    /**
     * 数据类型
     */
    private String format = "json";

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * 签名类型
     */
    private String signType = "RSA2";

    /**
     * 主体
     */
    private String body = "支付宝支付";

    /**
     * 主题
     */
    private String subject = "支付宝支付";

    /**
     * 超时时间
     */
    private String timeoutExpress = "30m";

    public String getAppCertPath() {
        return appCertPath;
    }

    public void setAppCertPath(String appCertPath) {
        this.appCertPath = appCertPath;
    }

    public String getAliPayCertPath() {
        return aliPayCertPath;
    }

    public void setAliPayCertPath(String aliPayCertPath) {
        this.aliPayCertPath = aliPayCertPath;
    }

    public String getAliPayRootCertPath() {
        return aliPayRootCertPath;
    }

    public void setAliPayRootCertPath(String aliPayRootCertPath) {
        this.aliPayRootCertPath = aliPayRootCertPath;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTimeoutExpress() {
        return timeoutExpress;
    }

    public void setTimeoutExpress(String timeoutExpress) {
        this.timeoutExpress = timeoutExpress;
    }
}
