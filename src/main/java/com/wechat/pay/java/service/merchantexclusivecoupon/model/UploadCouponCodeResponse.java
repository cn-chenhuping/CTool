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

import java.util.List;

import static com.wechat.pay.java.core.util.StringUtil.toIndentedString;

/** UploadCouponCodeResponse */
public class UploadCouponCodeResponse {
  /** 批次号 说明：商家券批次号 */
  @SerializedName("stock_id")
  private String stockId;
  /** 去重后上传code总数 说明：本次上传操作，去重后实际上传的code数目 */
  @SerializedName("total_count")
  private Long totalCount;
  /** 上传成功code个数 说明：本次上传操作上传成功个数 */
  @SerializedName("success_count")
  private Long successCount;
  /** 上传成功的code列表 说明：本次新增上传成功的code信息。 特殊规则：单个券code长度为【1，32】，条目个数限制为【1，200】。 */
  @SerializedName("success_codes")
  private List<String> successCodes;
  /**
   * 上传成功时间
   * 说明：上传操作完成时间，遵循[rfc3339](https://datatracker.ietf.org/doc/html/rfc3339)标准格式，格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC
   * 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。
   */
  @SerializedName("success_time")
  private String successTime;
  /** 上传失败code个数 说明：本次上传操作上传失败的code数 */
  @SerializedName("fail_count")
  private Long failCount;
  /** 上传失败的code及原因 说明：本次导入失败的code信息，请参照错误信息，修改后重试 */
  @SerializedName("fail_codes")
  private List<UploadCouponCodeFailReason> failCodes;
  /** 已存在的code列表 说明：历史已存在的code列表，本次不会重复导入。 特殊规则：单个券code长度为【1，32】，条目个数限制为【1，200】。 */
  @SerializedName("exist_codes")
  private List<String> existCodes;
  /**
   * 本次请求中重复的code列表 说明：本次重复导入的code会被自动过滤，仅保留一个做导入，如满足要求则成功；如不满足要求，则失败；请参照报错提示修改重试。
   * 特殊规则：单个券code长度为【1，32】，条目个数限制为【1，200】。
   */
  @SerializedName("duplicate_codes")
  private List<String> duplicateCodes;

  public String getStockId() {
    return stockId;
  }

  public void setStockId(String stockId) {
    this.stockId = stockId;
  }

  public Long getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Long totalCount) {
    this.totalCount = totalCount;
  }

  public Long getSuccessCount() {
    return successCount;
  }

  public void setSuccessCount(Long successCount) {
    this.successCount = successCount;
  }

  public List<String> getSuccessCodes() {
    return successCodes;
  }

  public void setSuccessCodes(List<String> successCodes) {
    this.successCodes = successCodes;
  }

  public String getSuccessTime() {
    return successTime;
  }

  public void setSuccessTime(String successTime) {
    this.successTime = successTime;
  }

  public Long getFailCount() {
    return failCount;
  }

  public void setFailCount(Long failCount) {
    this.failCount = failCount;
  }

  public List<UploadCouponCodeFailReason> getFailCodes() {
    return failCodes;
  }

  public void setFailCodes(List<UploadCouponCodeFailReason> failCodes) {
    this.failCodes = failCodes;
  }

  public List<String> getExistCodes() {
    return existCodes;
  }

  public void setExistCodes(List<String> existCodes) {
    this.existCodes = existCodes;
  }

  public List<String> getDuplicateCodes() {
    return duplicateCodes;
  }

  public void setDuplicateCodes(List<String> duplicateCodes) {
    this.duplicateCodes = duplicateCodes;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadCouponCodeResponse {\n");
    sb.append("    stockId: ").append(toIndentedString(stockId)).append("\n");
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
    sb.append("    successCount: ").append(toIndentedString(successCount)).append("\n");
    sb.append("    successCodes: ").append(toIndentedString(successCodes)).append("\n");
    sb.append("    successTime: ").append(toIndentedString(successTime)).append("\n");
    sb.append("    failCount: ").append(toIndentedString(failCount)).append("\n");
    sb.append("    failCodes: ").append(toIndentedString(failCodes)).append("\n");
    sb.append("    existCodes: ").append(toIndentedString(existCodes)).append("\n");
    sb.append("    duplicateCodes: ").append(toIndentedString(duplicateCodes)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
