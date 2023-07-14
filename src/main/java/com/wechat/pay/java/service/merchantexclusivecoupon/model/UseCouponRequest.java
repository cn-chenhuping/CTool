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

/** UseCouponRequest */
public class UseCouponRequest {
  /** 券code 说明：券的唯一标识 */
  @SerializedName("coupon_code")
  private String couponCode;
  /**
   * 批次号
   * 说明：微信为每个商家券批次分配的唯一ID，当你在创建商家券接口中的coupon\\_code\\_mode参数传值为MERCHANT\\_API或者MERCHANT\\_UPLOAD时，则核销接口中该字段必传，否则该字段可不传
   */
  @SerializedName("stock_id")
  private String stockId;
  /**
   * 公众账号ID 说明：支持传入与当前调用接口商户号有绑定关系的AppID。支持小程序AppID与公众号AppID。核销接口返回的OpenID会在该传入AppID下进行计算获得。
   * 校验规则：传入的AppID得是与调用方商户号（即请求头里面的商户号）有绑定关系的AppID或传入的AppID得是归属商户号有绑定关系的AppID
   */
  @SerializedName("appid")
  private String appid;
  /**
   * 请求核销时间 说明：商户请求核销用户券的时间。
   * 遵循[rfc3339](https://datatracker.ietf.org/doc/html/rfc3339)标准格式，格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC
   * 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。
   */
  @SerializedName("use_time")
  private String useTime;
  /** 核销请求单据号 说明：每次核销请求的唯一标识，商户需保证唯一 */
  @SerializedName("use_request_no")
  private String useRequestNo;
  /**
   * 用户标识 说明：用户的唯一标识，做安全校验使用，非必填。
   * 校验规则：传入的OpenID得是调用方商户号（即请求头里面的商户号）有绑定关系的AppID获取的OpenID或传入的OpenID得是归属商户号有绑定关系的AppID获取的OpenID。[获取OpenID文档](https://pay.weixin.qq.com/wiki/doc/apiv3/terms_definition/chapter1_1_3.shtml#part-3)
   */
  @SerializedName("openid")
  private String openid;

  public String getCouponCode() {
    return couponCode;
  }

  public void setCouponCode(String couponCode) {
    this.couponCode = couponCode;
  }

  public String getStockId() {
    return stockId;
  }

  public void setStockId(String stockId) {
    this.stockId = stockId;
  }

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getUseTime() {
    return useTime;
  }

  public void setUseTime(String useTime) {
    this.useTime = useTime;
  }

  public String getUseRequestNo() {
    return useRequestNo;
  }

  public void setUseRequestNo(String useRequestNo) {
    this.useRequestNo = useRequestNo;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UseCouponRequest {\n");
    sb.append("    couponCode: ").append(toIndentedString(couponCode)).append("\n");
    sb.append("    stockId: ").append(toIndentedString(stockId)).append("\n");
    sb.append("    appid: ").append(toIndentedString(appid)).append("\n");
    sb.append("    useTime: ").append(toIndentedString(useTime)).append("\n");
    sb.append("    useRequestNo: ").append(toIndentedString(useRequestNo)).append("\n");
    sb.append("    openid: ").append(toIndentedString(openid)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
