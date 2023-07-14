// Copyright 2021 Tencent Inc. All rights reserved.
//
// 商家转账对外API
//
// * 场景及业务流程：     商户可通过该产品实现同时向多个用户微信零钱进行转账的操作，可用于发放奖金补贴、佣金货款结算、员工报销等场景。
// [https://pay.weixin.qq.com/index.php/public/product/detail?pid=108&productType=0](https://pay.weixin.qq.com/index.php/public/product/detail?pid=108&productType=0) * 接入步骤：     * 商户在微信支付商户平台开通“批量转账到零钱”产品权限，并勾选“使用API方式发起转账”。     * 调用批量转账接口，对多个用户微信零钱发起转账。     * 调用查询批次接口，可获取到转账批次详情及当前状态。     * 调用查询明细接口，可获取到单条转账明细详情及当前状态。
//
// API version: 1.0.4

// Code generated by WechatPay APIv3 Generator based on [OpenAPI
// Generator](https://openapi-generator.tech); DO NOT EDIT.

package com.wechat.pay.java.service.transferbatch.model;

import com.google.gson.annotations.SerializedName;

/** FailReasonType */
public enum FailReasonType {
  @SerializedName("ACCOUNT_FROZEN")
  ACCOUNT_FROZEN,

  @SerializedName("REAL_NAME_CHECK_FAIL")
  REAL_NAME_CHECK_FAIL,

  @SerializedName("NAME_NOT_CORRECT")
  NAME_NOT_CORRECT,

  @SerializedName("OPENID_INVALID")
  OPENID_INVALID,

  @SerializedName("TRANSFER_QUOTA_EXCEED")
  TRANSFER_QUOTA_EXCEED,

  @SerializedName("DAY_RECEIVED_QUOTA_EXCEED")
  DAY_RECEIVED_QUOTA_EXCEED,

  @SerializedName("MONTH_RECEIVED_QUOTA_EXCEED")
  MONTH_RECEIVED_QUOTA_EXCEED,

  @SerializedName("DAY_RECEIVED_COUNT_EXCEED")
  DAY_RECEIVED_COUNT_EXCEED,

  @SerializedName("PRODUCT_AUTH_CHECK_FAIL")
  PRODUCT_AUTH_CHECK_FAIL,

  @SerializedName("OVERDUE_CLOSE")
  OVERDUE_CLOSE,

  @SerializedName("ID_CARD_NOT_CORRECT")
  ID_CARD_NOT_CORRECT,

  @SerializedName("ACCOUNT_NOT_EXIST")
  ACCOUNT_NOT_EXIST,

  @SerializedName("TRANSFER_RISK")
  TRANSFER_RISK,

  @SerializedName("OTHER_FAIL_REASON_TYPE")
  OTHER_FAIL_REASON_TYPE,

  @SerializedName("REALNAME_ACCOUNT_RECEIVED_QUOTA_EXCEED")
  REALNAME_ACCOUNT_RECEIVED_QUOTA_EXCEED,

  @SerializedName("RECEIVE_ACCOUNT_NOT_PERMMIT")
  RECEIVE_ACCOUNT_NOT_PERMMIT,

  @SerializedName("PAYEE_ACCOUNT_ABNORMAL")
  PAYEE_ACCOUNT_ABNORMAL,

  @SerializedName("PAYER_ACCOUNT_ABNORMAL")
  PAYER_ACCOUNT_ABNORMAL,

  @SerializedName("TRANSFER_SCENE_UNAVAILABLE")
  TRANSFER_SCENE_UNAVAILABLE,

  @SerializedName("TRANSFER_SCENE_INVALID")
  TRANSFER_SCENE_INVALID,

  @SerializedName("TRANSFER_REMARK_SET_FAIL")
  TRANSFER_REMARK_SET_FAIL,

  @SerializedName("RECEIVE_ACCOUNT_NOT_CONFIGURE")
  RECEIVE_ACCOUNT_NOT_CONFIGURE,

  @SerializedName("BLOCK_B2C_USERLIMITAMOUNT_BSRULE_MONTH")
  BLOCK_B2C_USERLIMITAMOUNT_BSRULE_MONTH,

  @SerializedName("BLOCK_B2C_USERLIMITAMOUNT_MONTH")
  BLOCK_B2C_USERLIMITAMOUNT_MONTH,

  @SerializedName("MERCHANT_REJECT")
  MERCHANT_REJECT,

  @SerializedName("MERCHANT_NOT_CONFIRM")
  MERCHANT_NOT_CONFIRM
}
