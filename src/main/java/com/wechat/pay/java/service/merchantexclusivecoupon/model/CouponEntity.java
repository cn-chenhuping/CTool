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

/** CouponEntity */
public class CouponEntity {
  /** 批次归属商户号 说明：代金券的所属商户号 */
  @SerializedName("belong_merchant")
  private String belongMerchant;
  /** 商家券批次名称 说明：批次名称，字数上限为21个，一个中文汉字/英文字母/数字均占用一个字数。 */
  @SerializedName("stock_name")
  private String stockName;
  /** 批次备注 说明：仅配置商户可见，用于自定义信息。字数上限为20个，一个中文汉字/英文字母/数字均占用一个字数。 */
  @SerializedName("comment")
  private String comment;
  /** 适用商品范围 说明：适用商品范围，字数上限为15个，一个中文汉字/英文字母/数字均占用一个字数。 */
  @SerializedName("goods_name")
  private String goodsName;
  /** 批次类型 说明：批次类型 */
  @SerializedName("stock_type")
  private BusiFavorStockType stockType;
  /** 是否允许转赠 说明：不填默认否，枚举值： true：是 false：否 该字段暂未开放 */
  @SerializedName("transferable")
  private Boolean transferable;
  /** 是否允许分享领券链接 说明：不填默认否，枚举值： true：是 false：否 该字段暂未开放 */
  @SerializedName("shareable")
  private Boolean shareable;
  /** 券状态 说明：商家券状态 */
  @SerializedName("coupon_state")
  private CouponStatus couponState;
  /** 样式信息 说明： */
  @SerializedName("display_pattern_info")
  private DisplayPatternInfo displayPatternInfo;
  /** 券核销规则 说明： */
  @SerializedName("coupon_use_rule")
  private CouponUseRule couponUseRule;
  /** 自定义入口 说明： */
  @SerializedName("custom_entrance")
  private CustomEntrance customEntrance;
  /** 券code 说明：券的唯一标识 */
  @SerializedName("coupon_code")
  private String couponCode;
  /** 批次号 说明：批次号 */
  @SerializedName("stock_id")
  private String stockId;
  /**
   * 券可使用开始时间 说明：用户领取到的这张券实际可使用的开始时间：如批次设置的领取后可用，则开始时间即为券的领取时间； 如批次设置的领取后第X天可用，则为领取时间后第X天00:00:00
   */
  @SerializedName("available_start_time")
  private String availableStartTime;
  /** 券过期时间 说明：用户领取到这张券的过期时间 */
  @SerializedName("expire_time")
  private String expireTime;
  /** 券领取时间 说明：用户领取到这张券的时间 */
  @SerializedName("receive_time")
  private String receiveTime;
  /** 发券请求单号 说明：发券时传入的唯一凭证 */
  @SerializedName("send_request_no")
  private String sendRequestNo;
  /** 核销请求单号 说明：核销时传入的唯一凭证（如券已被核销，将返回此字段） */
  @SerializedName("use_request_no")
  private String useRequestNo;
  /** 券核销时间 说明：券被核销的时间（如券已被核销，将返回此字段） */
  @SerializedName("use_time")
  private String useTime;
  /** 关联的商户订单号 说明：若商家券操作过关联商户订单信息，则该字段返回商家券已关联的商户订单号。 */
  @SerializedName("associate_out_trade_no")
  private String associateOutTradeNo;
  /** 回退请求单号 说明：回退时传入的唯一凭证（如券发生了退回，将返回此字段） */
  @SerializedName("return_request_no")
  private String returnRequestNo;
  /** 券回退时间 说明：券被回退的时间（如券发生了退回，将返回此字段） */
  @SerializedName("return_time")
  private String returnTime;
  /** 失效请求单号 说明：失效时传入的唯一凭证（如果一张券已失效，将返回此字段） */
  @SerializedName("deactivate_request_no")
  private String deactivateRequestNo;
  /** 券失效时间 说明：券被失效的时间（如果一张券已失效，将返回此字段） */
  @SerializedName("deactivate_time")
  private String deactivateTime;
  /** 失效原因 说明：失效一张券的原因（如果一张券已失效，可能返回此字段） */
  @SerializedName("deactivate_reason")
  private String deactivateReason;

  public String getBelongMerchant() {
    return belongMerchant;
  }

  public void setBelongMerchant(String belongMerchant) {
    this.belongMerchant = belongMerchant;
  }

  public String getStockName() {
    return stockName;
  }

  public void setStockName(String stockName) {
    this.stockName = stockName;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public BusiFavorStockType getStockType() {
    return stockType;
  }

  public void setStockType(BusiFavorStockType stockType) {
    this.stockType = stockType;
  }

  public Boolean getTransferable() {
    return transferable;
  }

  public void setTransferable(Boolean transferable) {
    this.transferable = transferable;
  }

  public Boolean getShareable() {
    return shareable;
  }

  public void setShareable(Boolean shareable) {
    this.shareable = shareable;
  }

  public CouponStatus getCouponState() {
    return couponState;
  }

  public void setCouponState(CouponStatus couponState) {
    this.couponState = couponState;
  }

  public DisplayPatternInfo getDisplayPatternInfo() {
    return displayPatternInfo;
  }

  public void setDisplayPatternInfo(DisplayPatternInfo displayPatternInfo) {
    this.displayPatternInfo = displayPatternInfo;
  }

  public CouponUseRule getCouponUseRule() {
    return couponUseRule;
  }

  public void setCouponUseRule(CouponUseRule couponUseRule) {
    this.couponUseRule = couponUseRule;
  }

  public CustomEntrance getCustomEntrance() {
    return customEntrance;
  }

  public void setCustomEntrance(CustomEntrance customEntrance) {
    this.customEntrance = customEntrance;
  }

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

  public String getAvailableStartTime() {
    return availableStartTime;
  }

  public void setAvailableStartTime(String availableStartTime) {
    this.availableStartTime = availableStartTime;
  }

  public String getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(String expireTime) {
    this.expireTime = expireTime;
  }

  public String getReceiveTime() {
    return receiveTime;
  }

  public void setReceiveTime(String receiveTime) {
    this.receiveTime = receiveTime;
  }

  public String getSendRequestNo() {
    return sendRequestNo;
  }

  public void setSendRequestNo(String sendRequestNo) {
    this.sendRequestNo = sendRequestNo;
  }

  public String getUseRequestNo() {
    return useRequestNo;
  }

  public void setUseRequestNo(String useRequestNo) {
    this.useRequestNo = useRequestNo;
  }

  public String getUseTime() {
    return useTime;
  }

  public void setUseTime(String useTime) {
    this.useTime = useTime;
  }

  public String getAssociateOutTradeNo() {
    return associateOutTradeNo;
  }

  public void setAssociateOutTradeNo(String associateOutTradeNo) {
    this.associateOutTradeNo = associateOutTradeNo;
  }

  public String getReturnRequestNo() {
    return returnRequestNo;
  }

  public void setReturnRequestNo(String returnRequestNo) {
    this.returnRequestNo = returnRequestNo;
  }

  public String getReturnTime() {
    return returnTime;
  }

  public void setReturnTime(String returnTime) {
    this.returnTime = returnTime;
  }

  public String getDeactivateRequestNo() {
    return deactivateRequestNo;
  }

  public void setDeactivateRequestNo(String deactivateRequestNo) {
    this.deactivateRequestNo = deactivateRequestNo;
  }

  public String getDeactivateTime() {
    return deactivateTime;
  }

  public void setDeactivateTime(String deactivateTime) {
    this.deactivateTime = deactivateTime;
  }

  public String getDeactivateReason() {
    return deactivateReason;
  }

  public void setDeactivateReason(String deactivateReason) {
    this.deactivateReason = deactivateReason;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CouponEntity {\n");
    sb.append("    belongMerchant: ").append(toIndentedString(belongMerchant)).append("\n");
    sb.append("    stockName: ").append(toIndentedString(stockName)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    goodsName: ").append(toIndentedString(goodsName)).append("\n");
    sb.append("    stockType: ").append(toIndentedString(stockType)).append("\n");
    sb.append("    transferable: ").append(toIndentedString(transferable)).append("\n");
    sb.append("    shareable: ").append(toIndentedString(shareable)).append("\n");
    sb.append("    couponState: ").append(toIndentedString(couponState)).append("\n");
    sb.append("    displayPatternInfo: ").append(toIndentedString(displayPatternInfo)).append("\n");
    sb.append("    couponUseRule: ").append(toIndentedString(couponUseRule)).append("\n");
    sb.append("    customEntrance: ").append(toIndentedString(customEntrance)).append("\n");
    sb.append("    couponCode: ").append(toIndentedString(couponCode)).append("\n");
    sb.append("    stockId: ").append(toIndentedString(stockId)).append("\n");
    sb.append("    availableStartTime: ").append(toIndentedString(availableStartTime)).append("\n");
    sb.append("    expireTime: ").append(toIndentedString(expireTime)).append("\n");
    sb.append("    receiveTime: ").append(toIndentedString(receiveTime)).append("\n");
    sb.append("    sendRequestNo: ").append(toIndentedString(sendRequestNo)).append("\n");
    sb.append("    useRequestNo: ").append(toIndentedString(useRequestNo)).append("\n");
    sb.append("    useTime: ").append(toIndentedString(useTime)).append("\n");
    sb.append("    associateOutTradeNo: ")
        .append(toIndentedString(associateOutTradeNo))
        .append("\n");
    sb.append("    returnRequestNo: ").append(toIndentedString(returnRequestNo)).append("\n");
    sb.append("    returnTime: ").append(toIndentedString(returnTime)).append("\n");
    sb.append("    deactivateRequestNo: ")
        .append(toIndentedString(deactivateRequestNo))
        .append("\n");
    sb.append("    deactivateTime: ").append(toIndentedString(deactivateTime)).append("\n");
    sb.append("    deactivateReason: ").append(toIndentedString(deactivateReason)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
