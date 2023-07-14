// Copyright 2021 Tencent Inc. All rights reserved.
//
// 境内普通商户退款API
//
// 境内普通商户退款功能涉及的API文档
//
// API version: 1.2.0

// Code generated by WechatPay APIv3 Generator based on [OpenAPI
// Generator](https://openapi-generator.tech); DO NOT EDIT.

package com.wechat.pay.java.service.refund;

import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.exception.HttpException;
import com.wechat.pay.java.core.exception.MalformedMessageException;
import com.wechat.pay.java.core.exception.ServiceException;
import com.wechat.pay.java.core.exception.ValidationException;
import com.wechat.pay.java.core.http.*;
import com.wechat.pay.java.service.refund.model.CreateRequest;
import com.wechat.pay.java.service.refund.model.QueryByOutRefundNoRequest;
import com.wechat.pay.java.service.refund.model.Refund;

import static com.wechat.pay.java.core.http.UrlEncoder.urlEncode;
import static com.wechat.pay.java.core.util.GsonUtil.toJson;
import static java.util.Objects.requireNonNull;

/** RefundService服务 */
public class RefundService {

  private final HttpClient httpClient;
  private final HostName hostName;

  private RefundService(HttpClient httpClient, HostName hostName) {
    this.httpClient = requireNonNull(httpClient);
    this.hostName = hostName;
  }
  /** RefundService构造器 */
  public static class Builder {

    private HttpClient httpClient;
    private HostName hostName;
    /**
     * 设置请求配置，以该配置构造默认的httpClient，若未调用httpClient()方法，则必须调用该方法
     *
     * @param config 请求配置
     * @return Builder
     */
    public Builder config(Config config) {
      this.httpClient = new DefaultHttpClientBuilder().config(config).build();
      return this;
    }
    /**
     * 设置微信支付域名，可选，默认为api.mch.weixin.qq.com
     *
     * @param hostName 微信支付域名
     * @return Builder
     */
    public Builder hostName(HostName hostName) {
      this.hostName = hostName;
      return this;
    }
    /**
     * 设置自定义httpClient，若未调用config()，则必须调用该方法
     *
     * @param httpClient httpClient
     * @return Builder
     */
    public Builder httpClient(HttpClient httpClient) {
      this.httpClient = httpClient;
      return this;
    }
    /**
     * 构造服务
     *
     * @return RefundService
     */
    public RefundService build() {
      return new RefundService(httpClient, hostName);
    }
  }

  /**
   * 退款申请
   *
   * @param request 请求参数
   * @return Refund
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws MalformedMessageException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public Refund create(CreateRequest request) {
    String requestPath = "https://api.mch.weixin.qq.com/v3/refund/domestic/refunds";
    CreateRequest realRequest = request;
    if (this.hostName != null) {
      requestPath = requestPath.replaceFirst(HostName.API.getValue(), hostName.getValue());
    }
    HttpHeaders headers = new HttpHeaders();
    headers.addHeader(Constant.ACCEPT, MediaType.APPLICATION_JSON.getValue());
    headers.addHeader(Constant.CONTENT_TYPE, MediaType.APPLICATION_JSON.getValue());
    HttpRequest httpRequest =
        new HttpRequest.Builder()
            .httpMethod(HttpMethod.POST)
            .url(requestPath)
            .headers(headers)
            .body(createRequestBody(realRequest))
            .build();
    HttpResponse<Refund> httpResponse = httpClient.execute(httpRequest, Refund.class);
    return httpResponse.getServiceResponse();
  }
  /**
   * 查询单笔退款（通过商户退款单号）
   *
   * @param request 请求参数
   * @return Refund
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws MalformedMessageException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public Refund queryByOutRefundNo(QueryByOutRefundNoRequest request) {
    String requestPath = "https://api.mch.weixin.qq.com/v3/refund/domestic/refunds/{out_refund_no}";

    QueryByOutRefundNoRequest realRequest = request;
    // 添加 path param
    requestPath =
        requestPath.replace("{" + "out_refund_no" + "}", urlEncode(realRequest.getOutRefundNo()));

    // 添加 query param
    QueryParameter queryParameter = new QueryParameter();
    if (realRequest.getSubMchid() != null) {
      queryParameter.add("sub_mchid", urlEncode(realRequest.getSubMchid()));
    }
    requestPath += queryParameter.getQueryStr();
    if (this.hostName != null) {
      requestPath = requestPath.replaceFirst(HostName.API.getValue(), hostName.getValue());
    }
    HttpHeaders headers = new HttpHeaders();
    headers.addHeader(Constant.ACCEPT, MediaType.APPLICATION_JSON.getValue());
    headers.addHeader(Constant.CONTENT_TYPE, MediaType.APPLICATION_JSON.getValue());
    HttpRequest httpRequest =
        new HttpRequest.Builder()
            .httpMethod(HttpMethod.GET)
            .url(requestPath)
            .headers(headers)
            .build();
    HttpResponse<Refund> httpResponse = httpClient.execute(httpRequest, Refund.class);
    return httpResponse.getServiceResponse();
  }

  private RequestBody createRequestBody(Object request) {
    return new JsonRequestBody.Builder().body(toJson(request)).build();
  }
}
