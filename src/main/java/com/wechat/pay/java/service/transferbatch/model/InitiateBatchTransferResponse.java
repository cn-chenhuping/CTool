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

import static com.wechat.pay.java.core.util.StringUtil.toIndentedString;

/** InitiateBatchTransferResponse */
public class InitiateBatchTransferResponse {
  /** 商家批次单号 说明：商户系统内部的商家批次单号，在商户系统内部唯一 */
  @SerializedName("out_batch_no")
  private String outBatchNo;
  /** 微信批次单号 说明：微信批次单号，微信商家转账系统返回的唯一标识 */
  @SerializedName("batch_id")
  private String batchId;
  /** 批次创建时间 说明：批次受理成功时返回，按照使用rfc3339所定义的格式，格式为YYYY-MM-DDThh:mm:ss+TIMEZONE */
  @SerializedName("create_time")
  private String createTime;

  public String getOutBatchNo() {
    return outBatchNo;
  }

  public void setOutBatchNo(String outBatchNo) {
    this.outBatchNo = outBatchNo;
  }

  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InitiateBatchTransferResponse {\n");
    sb.append("    outBatchNo: ").append(toIndentedString(outBatchNo)).append("\n");
    sb.append("    batchId: ").append(toIndentedString(batchId)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}