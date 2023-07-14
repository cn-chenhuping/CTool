package com.wechat.pay.java.core;

import com.wechat.pay.java.core.certificate.CertificateProvider;
import com.wechat.pay.java.core.certificate.RSAAutoCertificateProvider;
import com.wechat.pay.java.core.cipher.AeadAesCipher;
import com.wechat.pay.java.core.cipher.AeadCipher;
import com.wechat.pay.java.core.cipher.RSAVerifier;
import com.wechat.pay.java.core.cipher.Verifier;
import com.wechat.pay.java.core.http.AbstractHttpClientBuilder;
import com.wechat.pay.java.core.http.HttpClient;
import com.wechat.pay.java.core.notification.NotificationConfig;

import java.nio.charset.StandardCharsets;

import static com.wechat.pay.java.core.notification.Constant.AES_CIPHER_ALGORITHM;
import static com.wechat.pay.java.core.notification.Constant.RSA_SIGN_TYPE;
import static java.util.Objects.requireNonNull;

/** 具有自动下载平台证书能力的RSA配置类 */
public final class RSAAutoCertificateConfig extends AbstractRSAConfig
    implements NotificationConfig {

  private final CertificateProvider certificateProvider;
  private final AeadCipher aeadCipher;

  private RSAAutoCertificateConfig(Builder builder) {
    super(
        builder.merchantId,
        builder.privateKey,
        builder.merchantSerialNumber,
        builder.certificateProvider);
    this.certificateProvider = builder.certificateProvider;
    this.aeadCipher = new AeadAesCipher(builder.apiV3Key);
  }

  /**
   * 获取签名类型
   *
   * @return 签名类型
   */
  @Override
  public String getSignType() {
    return RSA_SIGN_TYPE;
  }

  /**
   * 获取认证加解密器类型
   *
   * @return 认证加解密器类型
   */
  @Override
  public String getCipherType() {
    return AES_CIPHER_ALGORITHM;
  }

  /**
   * 创建验签器
   *
   * @return 验签器
   */
  @Override
  public Verifier createVerifier() {
    return new RSAVerifier(certificateProvider);
  }

  /**
   * 创建认证加解密器
   *
   * @return 认证加解密器
   */
  @Override
  public AeadCipher createAeadCipher() {
    return aeadCipher;
  }

  public static class Builder extends AbstractRSAConfigBuilder<Builder> {
    protected HttpClient httpClient;
    protected byte[] apiV3Key;
    protected CertificateProvider certificateProvider;
    protected AbstractHttpClientBuilder<?> httpClientBuilder;

    public Builder apiV3Key(String apiV3key) {
      this.apiV3Key = apiV3key.getBytes(StandardCharsets.UTF_8);
      return self();
    }

    public Builder httpClient(HttpClient httpClient) {
      this.httpClient = httpClient;
      return this;
    }

    public Builder httpClientBuilder(AbstractHttpClientBuilder<?> builder) {
      httpClientBuilder = builder;
      return this;
    }

    @Override
    protected Builder self() {
      return this;
    }

    public com.wechat.pay.java.core.RSAAutoCertificateConfig build() {
      RSAAutoCertificateProvider.Builder providerBuilder =
          new RSAAutoCertificateProvider.Builder()
              .merchantId(requireNonNull(merchantId))
              .apiV3Key(requireNonNull(apiV3Key))
              .privateKey(requireNonNull(privateKey))
              .merchantSerialNumber(requireNonNull(merchantSerialNumber));

      if (httpClient != null) {
        providerBuilder.httpClient(httpClient);
      }

      if (httpClientBuilder != null) {
        providerBuilder.httpClientBuilder(httpClientBuilder);
      }

      certificateProvider = providerBuilder.build();

      return new com.wechat.pay.java.core.RSAAutoCertificateConfig(this);
    }
  }
}
