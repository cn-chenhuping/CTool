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
import com.wechat.pay.java.core.cipher.Encryption;

import java.util.function.UnaryOperator;

import static com.wechat.pay.java.core.util.StringUtil.toIndentedString;

/** TransferDetailInput */
public class TransferDetailInput{
  /** 商家明细单号 说明：商户系统内部区分转账批次单下不同转账明细单的唯一标识，要求此参数只能由数字、大小写字母组成 */
  @SerializedName("out_detail_no")
  private String outDetailNo;
  /** 转账金额 说明：转账金额单位为“分” */
  @SerializedName("transfer_amount")
  private Long transferAmount;
  /** 转账备注 说明：单条转账备注（微信用户会收到该备注），UTF8编码，最多允许32个字符 */
  @SerializedName("transfer_remark")
  private String transferRemark;
  /** 收款用户openid 说明：商户appid下，某用户的openid */
  @SerializedName("openid")
  private String openid;
  /**
   * 收款用户姓名 说明：收款方真实姓名。支持标准RSA算法和国密算法，公钥由微信侧提供 明细转账金额<0.3元时，不允许填写收款用户姓名 明细转账金额 >=
   * 2,000元时，该笔明细必须填写收款用户姓名 同一批次转账明细中的姓名字段传入规则需保持一致，也即全部填写、或全部不填写
   * 若商户传入收款用户姓名，微信支付会校验用户openID与姓名是否一致，并提供电子回单
   */
  @Encryption
  @SerializedName("user_name")
  private String userName;

  public String getOutDetailNo() {
    return outDetailNo;
  }

  public void setOutDetailNo(String outDetailNo) {
    this.outDetailNo = outDetailNo;
  }

  public Long getTransferAmount() {
    return transferAmount;
  }

  public void setTransferAmount(Long transferAmount) {
    this.transferAmount = transferAmount;
  }

  public String getTransferRemark() {
    return transferRemark;
  }

  public void setTransferRemark(String transferRemark) {
    this.transferRemark = transferRemark;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransferDetailInput {\n");
    sb.append("    outDetailNo: ").append(toIndentedString(outDetailNo)).append("\n");
    sb.append("    transferAmount: ").append(toIndentedString(transferAmount)).append("\n");
    sb.append("    transferRemark: ").append(toIndentedString(transferRemark)).append("\n");
    sb.append("    openid: ").append(toIndentedString(openid)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  public TransferDetailInput cloneWithCipher(UnaryOperator<String> s) {
    TransferDetailInput copy = new TransferDetailInput();
    copy.outDetailNo = outDetailNo;
    copy.transferAmount = transferAmount;
    copy.transferRemark = transferRemark;
    copy.openid = openid;
    if (userName != null && !userName.isEmpty()) {
      copy.userName = s.apply(userName);
    }
    return copy;
  }
}
