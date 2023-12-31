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

/** PROCESSING - 处理中，上传任务处理中，请等待 FINISHED - 已完成，上传任务已处理完成，任务上传的文件中的用户已导入到号码包中 */
public enum TaskStatus {
  @SerializedName("PROCESSING")
  PROCESSING,

  @SerializedName("FINISHED")
  FINISHED
}
