// Copyright 2021 Tencent Inc. All rights reserved.
//
// 微工卡接口文档
//
// 服务商通过本API文档提供的接口，查询商户和微工卡的授权关系、生成预授权的token口令、核身预下单、核身结果的查询等。
//
// API version: 1.5.2

// Code generated by WechatPay APIv3 Generator based on [OpenAPI
// Generator](https://openapi-generator.tech); DO NOT EDIT.

package com.wechat.pay.java.service.payrollcard.model;

import com.google.gson.annotations.SerializedName;

/** EmploymentType */
public enum EmploymentType {
  @SerializedName("LONG_TERM_EMPLOYMENT")
  LONG_TERM_EMPLOYMENT,

  @SerializedName("SHORT_TERM_EMPLOYMENT")
  SHORT_TERM_EMPLOYMENT,

  @SerializedName("COOPERATION_EMPLOYMENT")
  COOPERATION_EMPLOYMENT
}
