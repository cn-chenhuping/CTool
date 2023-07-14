// Copyright 2021 Tencent Inc. All rights reserved.
//
// 公共出行平台代扣服务对外API
//
// 公共出行平台代扣服务对外API
//
// API version: 1.0.0

// Code generated by WechatPay APIv3 Generator based on [OpenAPI
// Generator](https://openapi-generator.tech); DO NOT EDIT.

package com.wechat.pay.java.service.weixinpayscanandride.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.wechat.pay.java.core.util.StringUtil.toIndentedString;

/** QueryUserServiceRequest */
public class QueryUserServiceRequest {
  /** 公众账号ID 说明：商户在微信申请公众号或移动应用成功后分配的账号ID，登录平台为mp.weixin.qq.com或open.weixin.qq.com */
  @SerializedName("appid")
  @Expose(serialize = false)
  private String appid;
  /** 子公众账号ID 说明：子公众账号ID，服务商模式下选传 */
  @SerializedName("sub_appid")
  @Expose(serialize = false)
  private String subAppid;
  /** 子商户号 说明：微信支付分配的子商户号，服务商模式下必传 */
  @SerializedName("sub_mchid")
  @Expose(serialize = false)
  private String subMchid;
  /** 代扣签约ID 说明：签约成功后，微信返回代扣签约ID 查用户是否能继续使用乘车卡时必传 */
  @SerializedName("contract_id")
  @Expose(serialize = false)
  private String contractId;

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

  public String getSubMchid() {
    return subMchid;
  }

  public void setSubMchid(String subMchid) {
    this.subMchid = subMchid;
  }

  public String getContractId() {
    return contractId;
  }

  public void setContractId(String contractId) {
    this.contractId = contractId;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryUserServiceRequest {\n");
    sb.append("    appid: ").append(toIndentedString(appid)).append("\n");
    sb.append("    subAppid: ").append(toIndentedString(subAppid)).append("\n");
    sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
    sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}