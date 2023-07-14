package com.wechat.pay.java.core.cipher;

import com.wechat.pay.java.core.certificate.CertificateProvider;

import static com.wechat.pay.java.core.cipher.Constant.SHA256WITHRSA;

/** RSA验签器 */
public final class RSAVerifier extends AbstractVerifier {

  public RSAVerifier(CertificateProvider provider) {
    super(SHA256WITHRSA, provider);
  }
}
