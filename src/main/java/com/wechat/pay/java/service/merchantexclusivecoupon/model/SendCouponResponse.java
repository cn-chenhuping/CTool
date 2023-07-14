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

/** SendCouponResponse */
public class SendCouponResponse {
  /** 发券结果 说明：发券结果 */
  @SerializedName("send_coupon_result")
  private SendCouponResult sendCouponResult;

  public SendCouponResult getSendCouponResult() {
    return sendCouponResult;
  }

  public void setSendCouponResult(SendCouponResult sendCouponResult) {
    this.sendCouponResult = sendCouponResult;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendCouponResponse {\n");
    sb.append("    sendCouponResult: ").append(toIndentedString(sendCouponResult)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
