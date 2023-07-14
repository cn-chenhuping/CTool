package com.wechat.pay.java.core.http;

import com.wechat.pay.java.core.util.GsonUtil;

import static java.util.Objects.requireNonNull;

/** HTTP JSON类型请求体 */
public final class JsonRequestBody implements RequestBody {

  private final String body;

  private JsonRequestBody(String body) {
    this.body = body;
  }

  /**
   * 获取请求体
   *
   * @return 请求体
   */
  public String getBody() {
    return body;
  }

  @Override
  public String getContentType() {
    return MediaType.APPLICATION_JSON.getValue();
  }

  @Override
  public String toString() {
    return GsonUtil.getGson().toJson(this);
  }

  public static class Builder {

    private String body;

    public Builder body(String body) {
      this.body = body;
      return this;
    }

    public com.wechat.pay.java.core.http.JsonRequestBody build() {
      return new com.wechat.pay.java.core.http.JsonRequestBody(requireNonNull(body));
    }
  }
}
