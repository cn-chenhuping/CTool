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

/** QueryCouponCodeListRequest */
public class QueryCouponCodeListRequest {
  /** 批次号 说明：商家券批次号 */
  @SerializedName("stock_id")
  @Expose(serialize = false)
  private String stockId;
  /** 分页最大size 说明：分页查询的最大size */
  @SerializedName("limit")
  @Expose(serialize = false)
  private Long limit;
  /** 分页起始位置 说明：分页查询的起始位置 */
  @SerializedName("offset")
  @Expose(serialize = false)
  private Long offset;
  /** 公众账号ID 说明：公众账号ID */
  @SerializedName("appid")
  @Expose(serialize = false)
  private String appid;
  /** 券code状态 说明：券code状态，当不填写时为查询所有状态的code列表 */
  @SerializedName("status")
  @Expose(serialize = false)
  private CouponCodeStatus status;

  public String getStockId() {
    return stockId;
  }

  public void setStockId(String stockId) {
    this.stockId = stockId;
  }

  public Long getLimit() {
    return limit;
  }

  public void setLimit(Long limit) {
    this.limit = limit;
  }

  public Long getOffset() {
    return offset;
  }

  public void setOffset(Long offset) {
    this.offset = offset;
  }

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public CouponCodeStatus getStatus() {
    return status;
  }

  public void setStatus(CouponCodeStatus status) {
    this.status = status;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryCouponCodeListRequest {\n");
    sb.append("    stockId: ").append(toIndentedString(stockId)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    appid: ").append(toIndentedString(appid)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}