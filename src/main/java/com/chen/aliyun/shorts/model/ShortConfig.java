package com.chen.aliyun.shorts.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 阿里云短信服务请求参数
 * chenhuping
 * 2023-06-20
 */
@Data
@ConfigurationProperties(prefix = "aliyun.short.cn")
public class ShortConfig {
    private String outId;

    private Long ownerId;

    /**
     * 服务商电话
     */
    private String phoneNumbers;

    private String resourceOwnerAccount;

    private Long resourceOwnerId;

    /**
     * 服务商名
     */
    private String signName;

    private String smsUpExtendCode = "";

    /**
     * 模板序号
     */
    private String templateCode;

    /**
     * 内容参数
     */
    private String templateParam;

    /**
     * accessKeyId
     */
    private String accessKeyId;

    /**
     * accessKeySecret
     */
    private String accessKeySecret;
}
