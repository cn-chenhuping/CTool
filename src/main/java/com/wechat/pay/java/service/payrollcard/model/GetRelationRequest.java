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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.wechat.pay.java.core.util.StringUtil.toIndentedString;

/** GetRelationRequest */
public class GetRelationRequest {
  /** 用户OpenID 说明：微信用户OpenID */
  @SerializedName("openid")
  @Expose(serialize = false)
  private String openid;
  /** 特约商户号 说明：特约商户号 */
  @SerializedName("sub_mchid")
  @Expose(serialize = false)
  private String subMchid;
  /** 服务商AppID 说明：当输入服务商AppID时会校验其与服务商商户号绑定关系。 服务商AppID和特约商户AppID至少输入一个。 */
  @SerializedName("appid")
  @Expose(serialize = false)
  private String appid;
  /** 特约商户AppID 说明：当输入特约商户AppID时会校验其与特约商户号关系。 特约商户AppID和服务商AppID至少输入一个。 */
  @SerializedName("sub_appid")
  @Expose(serialize = false)
  private String subAppid;

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getSubMchid() {
    return subMchid;
  }

  public void setSubMchid(String subMchid) {
    this.subMchid = subMchid;
  }

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getSubAppid() {
    return subAppid;
  }

  public void setSubAppid(String subAppid) {
    this.subAppid = subAppid;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetRelationRequest {\n");
    sb.append("    openid: ").append(toIndentedString(openid)).append("\n");
    sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
    sb.append("    appid: ").append(toIndentedString(appid)).append("\n");
    sb.append("    subAppid: ").append(toIndentedString(subAppid)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}