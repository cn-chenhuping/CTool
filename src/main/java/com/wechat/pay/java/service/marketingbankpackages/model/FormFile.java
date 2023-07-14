// Copyright 2021 Tencent Inc. All rights reserved.
//
// 银行营销对外API
//
// # 前言
// 银行营销API是专为银行商户设置的一套API。目前仅包含“创建快捷交易协议号上传任务”接口，供银行上传快捷交易协议号文件。微信侧收到文件中，将快捷交易协议号转换为微信用户id，存储到指定的号码包文件中。
//
// API version: 0.1.0

// Code generated by WechatPay APIv3 Generator based on [OpenAPI
// Generator](https://openapi-generator.tech); DO NOT EDIT.

package com.wechat.pay.java.service.marketingbankpackages.model;

import com.google.gson.annotations.SerializedName;

import static com.wechat.pay.java.core.util.StringUtil.toIndentedString;

/** FormFile */
public class FormFile {
  /** 文件名 说明：由表单上传的文件部分的文件名 */
  @SerializedName("filename")
  private String filename;
  /** 文件类型 说明：表示上传文件的 Content-Type */
  @SerializedName("content_type")
  private String contentType;
  /** 文件内容 说明：一个二进制串表示上传文件的整体内容 */
  @SerializedName("content")
  private String content;

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormFile {\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}