// Copyright 2021 Tencent Inc. All rights reserved.
//
// H5支付
//
// H5支付API
//
// API version: 1.2.3

// Code generated by WechatPay APIv3 Generator based on [OpenAPI
// Generator](https://openapi-generator.tech); DO NOT EDIT.

package com.wechat.pay.java.service.partnerpayments.h5.model;

import com.google.gson.annotations.SerializedName;

import static com.wechat.pay.java.core.util.StringUtil.toIndentedString;

/** GoodsDetail */
public class GoodsDetail {
  /** 商户侧商品编码 说明：由半角的大小写字母、数字、中划线、下划线中的一种或几种组成。 */
  @SerializedName("merchant_goods_id")
  private String merchantGoodsId;
  /** 微信侧商品编码 说明：微信支付定义的统一商品编号（没有可不传）。 */
  @SerializedName("wechatpay_goods_id")
  private String wechatpayGoodsId;
  /** 商品名称 说明：商品的实际名称。 */
  @SerializedName("goods_name")
  private String goodsName;
  /** 商品数量 说明：用户购买的数量。 */
  @SerializedName("quantity")
  private Integer quantity;
  /** 商品单价 说明：商品单价，单位为分。 */
  @SerializedName("unit_price")
  private Integer unitPrice;

  public String getMerchantGoodsId() {
    return merchantGoodsId;
  }

  public void setMerchantGoodsId(String merchantGoodsId) {
    this.merchantGoodsId = merchantGoodsId;
  }

  public String getWechatpayGoodsId() {
    return wechatpayGoodsId;
  }

  public void setWechatpayGoodsId(String wechatpayGoodsId) {
    this.wechatpayGoodsId = wechatpayGoodsId;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Integer unitPrice) {
    this.unitPrice = unitPrice;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GoodsDetail {\n");
    sb.append("    merchantGoodsId: ").append(toIndentedString(merchantGoodsId)).append("\n");
    sb.append("    wechatpayGoodsId: ").append(toIndentedString(wechatpayGoodsId)).append("\n");
    sb.append("    goodsName: ").append(toIndentedString(goodsName)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
