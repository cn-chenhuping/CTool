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

/** CreateBusiFavorStockRequest */
public class CreateBusiFavorStockRequest {
  /** 商家券批次名称 说明：批次名称，字数上限为21个，一个中文汉字/英文字母/数字均占用一个字数。 */
  @SerializedName("stock_name")
  private String stockName;
  /** 批次归属商户号 说明：批次归属于哪个商户。 注： 普通直连模式，该参数为直连商户号； 服务商模式，该参数为子商户号； 间连模式，该参数为子商户号。 */
  @SerializedName("belong_merchant")
  private String belongMerchant;
  /** 批次备注 说明：仅配置商户可见，用于自定义信息。字数上限为20个，一个中文汉字/英文字母/数字均占用一个字数。 */
  @SerializedName("comment")
  private String comment;
  /** 适用商品范围 说明：用来描述批次在哪些商品可用，会显示在微信卡包中。字数上限为15个，一个中文汉字/英文字母/数字均占用一个字数。 */
  @SerializedName("goods_name")
  private String goodsName;
  /** 批次类型 说明：批次类型 */
  @SerializedName("stock_type")
  private BusiFavorStockType stockType;
  /** 核销规则 说明：券核销相关规则 */
  @SerializedName("coupon_use_rule")
  private CouponUseRule couponUseRule;
  /** 发放规则 说明：券发放相关规则 */
  @SerializedName("stock_send_rule")
  private StockSendRule stockSendRule;
  /** 商户请求单号 说明：商户创建批次凭据号（格式：商户ID+日期+流水号），商户侧需保持唯一性 */
  @SerializedName("out_request_no")
  private String outRequestNo;
  /** 自定义入口 说明：卡详情页面，可选择多种入口引导用户 */
  @SerializedName("custom_entrance")
  private CustomEntrance customEntrance;
  /** 样式信息 说明：创建批次时的样式信息。 */
  @SerializedName("display_pattern_info")
  private DisplayPatternInfo displayPatternInfo;
  /**
   * 券code模式 说明：特殊规则： 1、券code模式为WECHATPAY\\_MODE时，是微信自动分配券code，商户不需要预存code；适用于多种场景
   * 2、券code模式为MERCHANT\\_API时，无需调用上传预存code接口，调用发券接口时需指定券code；更多用在商家自有流量场景（例如：商家自有小程序、H5网页等）
   * 3、券code模式为MERCHANT\\_UPLOAD，需要调用上传预存code接口上传code，调用发券接口时无需指定code；更多适用在微信支付平台流量场景（例如：支付有礼、支付有优惠等）
   */
  @SerializedName("coupon_code_mode")
  private CouponCodeMode couponCodeMode;
  /** 事件通知配置 说明：事件回调通知商户的配置 */
  @SerializedName("notify_config")
  private NotifyConfig notifyConfig;
  /** 是否允许营销补差 说明：该批次发放的券是否允许进行补差，默认为false 注：该字段暂未开放 */
  @SerializedName("subsidy")
  private Boolean subsidy;

  public String getStockName() {
    return stockName;
  }

  public void setStockName(String stockName) {
    this.stockName = stockName;
  }

  public String getBelongMerchant() {
    return belongMerchant;
  }

  public void setBelongMerchant(String belongMerchant) {
    this.belongMerchant = belongMerchant;
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

  public CouponUseRule getCouponUseRule() {
    return couponUseRule;
  }

  public void setCouponUseRule(CouponUseRule couponUseRule) {
    this.couponUseRule = couponUseRule;
  }

  public StockSendRule getStockSendRule() {
    return stockSendRule;
  }

  public void setStockSendRule(StockSendRule stockSendRule) {
    this.stockSendRule = stockSendRule;
  }

  public String getOutRequestNo() {
    return outRequestNo;
  }

  public void setOutRequestNo(String outRequestNo) {
    this.outRequestNo = outRequestNo;
  }

  public CustomEntrance getCustomEntrance() {
    return customEntrance;
  }

  public void setCustomEntrance(CustomEntrance customEntrance) {
    this.customEntrance = customEntrance;
  }

  public DisplayPatternInfo getDisplayPatternInfo() {
    return displayPatternInfo;
  }

  public void setDisplayPatternInfo(DisplayPatternInfo displayPatternInfo) {
    this.displayPatternInfo = displayPatternInfo;
  }

  public CouponCodeMode getCouponCodeMode() {
    return couponCodeMode;
  }

  public void setCouponCodeMode(CouponCodeMode couponCodeMode) {
    this.couponCodeMode = couponCodeMode;
  }

  public NotifyConfig getNotifyConfig() {
    return notifyConfig;
  }

  public void setNotifyConfig(NotifyConfig notifyConfig) {
    this.notifyConfig = notifyConfig;
  }

  public Boolean getSubsidy() {
    return subsidy;
  }

  public void setSubsidy(Boolean subsidy) {
    this.subsidy = subsidy;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateBusiFavorStockRequest {\n");
    sb.append("    stockName: ").append(toIndentedString(stockName)).append("\n");
    sb.append("    belongMerchant: ").append(toIndentedString(belongMerchant)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    goodsName: ").append(toIndentedString(goodsName)).append("\n");
    sb.append("    stockType: ").append(toIndentedString(stockType)).append("\n");
    sb.append("    couponUseRule: ").append(toIndentedString(couponUseRule)).append("\n");
    sb.append("    stockSendRule: ").append(toIndentedString(stockSendRule)).append("\n");
    sb.append("    outRequestNo: ").append(toIndentedString(outRequestNo)).append("\n");
    sb.append("    customEntrance: ").append(toIndentedString(customEntrance)).append("\n");
    sb.append("    displayPatternInfo: ").append(toIndentedString(displayPatternInfo)).append("\n");
    sb.append("    couponCodeMode: ").append(toIndentedString(couponCodeMode)).append("\n");
    sb.append("    notifyConfig: ").append(toIndentedString(notifyConfig)).append("\n");
    sb.append("    subsidy: ").append(toIndentedString(subsidy)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
