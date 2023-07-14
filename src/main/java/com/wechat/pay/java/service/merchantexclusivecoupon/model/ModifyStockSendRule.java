// Copyright 2021 Tencent Inc. All rights reserved.
//
// 营销商家券对外API
//
// No description provided (generated by Openapi Generator
// https://github.com/openapitools/openapi-generator)
//
// API version: 0.0.11

// Code generated by WechatPay APIv3 Generator based on [OpenAPI
// Generator](https://openapi-generator.tech); DO NOT EDIT.

package com.wechat.pay.java.service.merchantexclusivecoupon.model;

import com.google.gson.annotations.SerializedName;

import static com.wechat.pay.java.core.util.StringUtil.toIndentedString;

/** ModifyStockSendRule */
public class ModifyStockSendRule {
  /** 是否开启自然人限领 说明：true-是；false-否，不填默认否 注：该字段暂不支持修改 */
  @SerializedName("natural_person_limit")
  private Boolean naturalPersonLimit;
  /** 可疑账号拦截 说明：true-是；false-否，不填默认否 */
  @SerializedName("prevent_api_abuse")
  private Boolean preventApiAbuse;

  public Boolean getNaturalPersonLimit() {
    return naturalPersonLimit;
  }

  public void setNaturalPersonLimit(Boolean naturalPersonLimit) {
    this.naturalPersonLimit = naturalPersonLimit;
  }

  public Boolean getPreventApiAbuse() {
    return preventApiAbuse;
  }

  public void setPreventApiAbuse(Boolean preventApiAbuse) {
    this.preventApiAbuse = preventApiAbuse;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyStockSendRule {\n");
    sb.append("    naturalPersonLimit: ").append(toIndentedString(naturalPersonLimit)).append("\n");
    sb.append("    preventApiAbuse: ").append(toIndentedString(preventApiAbuse)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
