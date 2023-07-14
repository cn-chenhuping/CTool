// Copyright 2021 Tencent Inc. All rights reserved.
//
// 境内普通商户退款API
//
// 境内普通商户退款功能涉及的API文档
//
// API version: 1.2.0

// Code generated by WechatPay APIv3 Generator based on [OpenAPI
// Generator](https://openapi-generator.tech); DO NOT EDIT.

package com.wechat.pay.java.service.refund.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static com.wechat.pay.java.core.util.StringUtil.toIndentedString;

/** CreateRequest */
public class CreateRequest {
  /** 子商户号 说明：子商户的商户号，由微信支付生成并下发。服务商模式下必须传递此参数 */
  @SerializedName("sub_mchid")
  private String subMchid;
  /** 微信支付订单号 说明：原支付交易对应的微信订单号 */
  @SerializedName("transaction_id")
  private String transactionId;
  /** 商户订单号 说明：原支付交易对应的商户订单号 */
  @SerializedName("out_trade_no")
  private String outTradeNo;
  /** 商户退款单号 说明：商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。 */
  @SerializedName("out_refund_no")
  private String outRefundNo;
  /** 退款原因 说明：若商户传入，会在下发给用户的退款消息中体现退款原因 */
  @SerializedName("reason")
  private String reason;
  /**
   * 退款结果回调url 说明：异步接收微信支付退款结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
   * 如果参数中传了notify_url，则商户平台上配置的回调地址将不会生效，优先回调当前传的这个地址。
   */
  @SerializedName("notify_url")
  private String notifyUrl;
  /** 退款商品 说明：指定商品退款需要传此参数，其他场景无需传递 */
  @SerializedName("goods_detail")
  private List<GoodsDetail> goodsDetail;
  /** 金额信息 说明：订单金额信息 */
  @SerializedName("amount")
  private AmountReq amount;
  /** 退款资金来源 说明：若传递此参数则使用对应的资金账户退款，否则默认使用未结算资金退款（仅对老资金流商户适用） 枚举值： - AVAILABLE：可用余额账户 */
  @SerializedName("funds_account")
  private ReqFundsAccount fundsAccount;

  public String getSubMchid() {
    return subMchid;
  }

  public void setSubMchid(String subMchid) {
    this.subMchid = subMchid;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public String getOutTradeNo() {
    return outTradeNo;
  }

  public void setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
  }

  public String getOutRefundNo() {
    return outRefundNo;
  }

  public void setOutRefundNo(String outRefundNo) {
    this.outRefundNo = outRefundNo;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getNotifyUrl() {
    return notifyUrl;
  }

  public void setNotifyUrl(String notifyUrl) {
    this.notifyUrl = notifyUrl;
  }

  public List<GoodsDetail> getGoodsDetail() {
    return goodsDetail;
  }

  public void setGoodsDetail(List<GoodsDetail> goodsDetail) {
    this.goodsDetail = goodsDetail;
  }

  public AmountReq getAmount() {
    return amount;
  }

  public void setAmount(AmountReq amount) {
    this.amount = amount;
  }

  public ReqFundsAccount getFundsAccount() {
    return fundsAccount;
  }

  public void setFundsAccount(ReqFundsAccount fundsAccount) {
    this.fundsAccount = fundsAccount;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateRequest {\n");
    sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
    sb.append("    outTradeNo: ").append(toIndentedString(outTradeNo)).append("\n");
    sb.append("    outRefundNo: ").append(toIndentedString(outRefundNo)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    notifyUrl: ").append(toIndentedString(notifyUrl)).append("\n");
    sb.append("    goodsDetail: ").append(toIndentedString(goodsDetail)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    fundsAccount: ").append(toIndentedString(fundsAccount)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
