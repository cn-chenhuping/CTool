package com.chen.aliyun.oss.model;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 阿里云OSS配置
 *
 * @author chenhuping
 */
@Component
@ConfigurationProperties(prefix = "aliyun.oss.file")
public class ConstantPropertiesUtils implements InitializingBean {

    /**
     * 阿里云oss地址
     */
    private String endpoint;

    /**
     * 密钥id
     */
    private String keyId;

    /**
     * 密钥secret
     */
    private String keySecret;

    /**
     * 桶端点
     */
    private String bucKetname;

    /**
     * 存储文件夹名称
     */
    private String filename;

    /**
     * 录音使用
     */
    private String record;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getKeySecret() {
        return keySecret;
    }

    public void setKeySecret(String keySecret) {
        this.keySecret = keySecret;
    }

    public String getBucKetname() {
        return bucKetname;
    }

    public void setBucKetname(String bucKetname) {
        this.bucKetname = bucKetname;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    //定义共有的静态常量
    public static String END_POINT;
    public static String KEY_ID;
    public static String KEY_SECRET;
    public static String BUCKET_NAME;
    public static String FILE_NAME;
    public static String RECORD;

    @Override
    public void afterPropertiesSet(){
        END_POINT = endpoint;
        KEY_ID = keyId;
        KEY_SECRET = keySecret;
        BUCKET_NAME = bucKetname;
        FILE_NAME = filename;
        RECORD = record;
    }
}