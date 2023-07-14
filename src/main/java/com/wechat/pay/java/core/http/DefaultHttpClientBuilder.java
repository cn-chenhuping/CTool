package com.wechat.pay.java.core.http;

import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.auth.Credential;
import com.wechat.pay.java.core.auth.Validator;
import com.wechat.pay.java.core.http.okhttp.OkHttpClientAdapter;
import com.wechat.pay.java.core.http.okhttp.OkHttpMultiDomainInterceptor;

import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import static java.util.Objects.requireNonNull;

/** 默认HttpClient构造器 */
public class DefaultHttpClientBuilder
    implements AbstractHttpClientBuilder<com.wechat.pay.java.core.http.DefaultHttpClientBuilder> {

  private Credential credential;
  private Validator validator;
  private static final okhttp3.OkHttpClient defaultOkHttpClient = new okhttp3.OkHttpClient();
  private okhttp3.OkHttpClient customizeOkHttpClient;
  private int readTimeoutMs = -1;
  private int writeTimeoutMs = -1;
  private int connectTimeoutMs = -1;
  private Proxy proxy;
  private boolean retryMultiDomain = false;
  private Boolean retryOnConnectionFailure = null;
  private static final OkHttpMultiDomainInterceptor multiDomainInterceptor =
      new OkHttpMultiDomainInterceptor();

  /**
   * 复制工厂，复制一个当前对象
   *
   * @return 对象的副本
   */
  @Override
  public com.wechat.pay.java.core.http.DefaultHttpClientBuilder newInstance() {
    com.wechat.pay.java.core.http.DefaultHttpClientBuilder result = new com.wechat.pay.java.core.http.DefaultHttpClientBuilder();
    result.credential = this.credential;
    result.validator = this.validator;
    result.customizeOkHttpClient = this.customizeOkHttpClient;
    result.readTimeoutMs = this.readTimeoutMs;
    result.writeTimeoutMs = this.writeTimeoutMs;
    result.connectTimeoutMs = this.connectTimeoutMs;
    result.proxy = this.proxy;
    return result;
  }

  /**
   * 设置读超时
   *
   * @param readTimeoutMs 读超时，单位毫秒
   * @return defaultHttpClientBuilder
   */
  public com.wechat.pay.java.core.http.DefaultHttpClientBuilder readTimeoutMs(int readTimeoutMs) {
    this.readTimeoutMs = readTimeoutMs;
    return this;
  }

  /**
   * 设置写超时
   *
   * @param writeTimeoutMs 写超时，单位毫秒
   * @return defaultHttpClientBuilder
   */
  public com.wechat.pay.java.core.http.DefaultHttpClientBuilder writeTimeoutMs(int writeTimeoutMs) {
    this.writeTimeoutMs = writeTimeoutMs;
    return this;
  }

  /**
   * 设置连接超时
   *
   * @param connectTimeoutMs 连接超时，单位毫秒
   * @return defaultHttpClientBuilder
   */
  public com.wechat.pay.java.core.http.DefaultHttpClientBuilder connectTimeoutMs(int connectTimeoutMs) {
    this.connectTimeoutMs = connectTimeoutMs;
    return this;
  }

  /**
   * 设置凭据生成器
   *
   * @param credential 凭据生成器
   * @return defaultHttpClientBuilder
   */
  @Override
  public com.wechat.pay.java.core.http.DefaultHttpClientBuilder credential(Credential credential) {
    this.credential = credential;
    return this;
  }

  /**
   * 设置验证器
   *
   * @param validator 验证器
   * @return defaultHttpClientBuilder
   */
  @Override
  public com.wechat.pay.java.core.http.DefaultHttpClientBuilder validator(Validator validator) {
    this.validator = validator;
    return this;
  }

  /**
   * 设置 okHttpClient 若设置该参数，会覆盖client中的原有配置
   *
   * @param okHttpClient 用户自定义的okHttpClient
   * @return defaultHttpClientBuilder
   */
  public com.wechat.pay.java.core.http.DefaultHttpClientBuilder okHttpClient(okhttp3.OkHttpClient okHttpClient) {
    this.customizeOkHttpClient = okHttpClient;
    return this;
  }

  public com.wechat.pay.java.core.http.DefaultHttpClientBuilder config(Config config) {
    requireNonNull(config);
    this.credential = config.createCredential();
    this.validator = config.createValidator();
    return this;
  }

  public com.wechat.pay.java.core.http.DefaultHttpClientBuilder proxy(Proxy proxy) {
    requireNonNull(proxy);
    this.proxy = proxy;
    return this;
  }

  /**
   * 启用双域名容灾
   *
   * @return defaultHttpClientBuilder
   */
  public com.wechat.pay.java.core.http.DefaultHttpClientBuilder enableRetryMultiDomain() {
    this.retryMultiDomain = true;
    return this;
  }

  /** OkHttp 在网络问题时不重试 */
  public com.wechat.pay.java.core.http.DefaultHttpClientBuilder disableRetryOnConnectionFailure() {
    this.retryOnConnectionFailure = false;
    return this;
  }

  /**
   * 构建默认HttpClient
   *
   * @return httpClient
   */
  @Override
  public AbstractHttpClient build() {
    requireNonNull(credential);
    requireNonNull(validator);
    okhttp3.OkHttpClient.Builder okHttpClientBuilder =
        (customizeOkHttpClient == null ? defaultOkHttpClient : customizeOkHttpClient).newBuilder();
    if (connectTimeoutMs >= 0) {
      okHttpClientBuilder.connectTimeout(connectTimeoutMs, TimeUnit.MILLISECONDS);
    }
    if (readTimeoutMs >= 0) {
      okHttpClientBuilder.readTimeout(readTimeoutMs, TimeUnit.MILLISECONDS);
    }
    if (writeTimeoutMs >= 0) {
      okHttpClientBuilder.writeTimeout(writeTimeoutMs, TimeUnit.MILLISECONDS);
    }
    if (proxy != null) {
      okHttpClientBuilder.proxy(proxy);
    }
    if (retryMultiDomain) {
      okHttpClientBuilder.addInterceptor(multiDomainInterceptor);
    }
    if (retryOnConnectionFailure != null && !retryOnConnectionFailure) {
      okHttpClientBuilder.retryOnConnectionFailure(false);
    }
    return new OkHttpClientAdapter(credential, validator, okHttpClientBuilder.build());
  }
}
