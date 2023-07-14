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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.wechat.pay.java.core.util.StringUtil.toIndentedString;

/** SendGovCardRequest */
public class SendGovCardRequest {
  /** 消费卡card_id 说明：消费券通用卡卡包card_id */
  @SerializedName("card_id")
  @Expose(serialize = false)
  private String cardId;
  /** 消费卡card_id创建方AppID 说明：消费卡cardi\\_d创建方的AppID，需与API调用方商户号有绑定关系，入参中的用户OpenID也需用此AppID生成 */
  @SerializedName("appid")
  private String appid;
  /** 用户OpenID 说明：待发券用户的OpenID，需为消费卡创建方AppID生成的OpenID */
  @SerializedName("openid")
  private String openid;
  /** 商户单据号 说明：商户此次发放凭据号。推荐使用大小写字母和数字，不同添加请求发放凭据号不同，商户侧需保证同一发券请求的out_request_no+send_time唯一性 */
  @SerializedName("out_request_no")
  private String outRequestNo;
  /**
   * 请求发卡时间
   * 说明：单次请求发卡时间，消费卡在商户系统的实际发放时间，为东八区标准时间（UTC+8）。商户需保证同一次请求的out_request_no+send_time唯一。由于系统限制，暂不支持传入早于当前时间24小时以上的时间进行发券请求。
   */
  @SerializedName("send_time")
  private String sendTime;

  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getOutRequestNo() {
    return outRequestNo;
  }

  public void setOutRequestNo(String outRequestNo) {
    this.outRequestNo = outRequestNo;
  }

  public String getSendTime() {
    return sendTime;
  }

  public void setSendTime(String sendTime) {
    this.sendTime = sendTime;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendGovCardRequest {\n");
    sb.append("    cardId: ").append(toIndentedString(cardId)).append("\n");
    sb.append("    appid: ").append(toIndentedString(appid)).append("\n");
    sb.append("    openid: ").append(toIndentedString(openid)).append("\n");
    sb.append("    outRequestNo: ").append(toIndentedString(outRequestNo)).append("\n");
    sb.append("    sendTime: ").append(toIndentedString(sendTime)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
