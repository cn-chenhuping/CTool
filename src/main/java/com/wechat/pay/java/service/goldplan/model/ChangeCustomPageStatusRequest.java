// Copyright 2021 Tencent Inc. All rights reserved.
//
// 点金计划对外API
//
// 特约商户点金计划管理API
//
// API version: 0.2.3

// Code generated by WechatPay APIv3 Generator based on [OpenAPI
// Generator](https://openapi-generator.tech); DO NOT EDIT.

package com.wechat.pay.java.service.goldplan.model;

import com.google.gson.annotations.SerializedName;

import static com.wechat.pay.java.core.util.StringUtil.toIndentedString;

/** ChangeCustomPageStatusRequest */
public class ChangeCustomPageStatusRequest {
  /** 特约商户号 说明：开通或关闭“商家自定义小票”的特约商户商户号，由微信支付生成并下发。 */
  @SerializedName("sub_mchid")
  private String subMchid;
  /** 操作类型 说明：开通或关闭“商家自定义小票”的动作，枚举值： OPEN：表示开通 CLOSE：表示关闭 */
  @SerializedName("operation_type")
  private OperationType operationType;

  public String getSubMchid() {
    return subMchid;
  }

  public void setSubMchid(String subMchid) {
    this.subMchid = subMchid;
  }

  public OperationType getOperationType() {
    return operationType;
  }

  public void setOperationType(OperationType operationType) {
    this.operationType = operationType;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChangeCustomPageStatusRequest {\n");
    sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
    sb.append("    operationType: ").append(toIndentedString(operationType)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
