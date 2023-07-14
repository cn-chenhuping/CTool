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

/** UseCouponResponse */
public class UseCouponResponse {
  /** 批次号 说明：批次ID */
  @SerializedName("stock_id")
  private String stockId;
  /** 用户标识 说明：用户在该公众号内的唯一身份标识。 */
  @SerializedName("openid")
  private String openid;
  /**
   * 系统核销券成功的时间
   * 说明：系统成功核销券的时间，遵循[rfc3339](https://datatracker.ietf.org/doc/html/rfc3339)标准格式，格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC
   * 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。
   */
  @SerializedName("wechatpay_use_time")
  private String wechatpayUseTime;

  public String getStockId() {
    return stockId;
  }

  public void setStockId(String stockId) {
    this.stockId = stockId;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getWechatpayUseTime() {
    return wechatpayUseTime;
  }

  public void setWechatpayUseTime(String wechatpayUseTime) {
    this.wechatpayUseTime = wechatpayUseTime;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UseCouponResponse {\n");
    sb.append("    stockId: ").append(toIndentedString(stockId)).append("\n");
    sb.append("    openid: ").append(toIndentedString(openid)).append("\n");
    sb.append("    wechatpayUseTime: ").append(toIndentedString(wechatpayUseTime)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
