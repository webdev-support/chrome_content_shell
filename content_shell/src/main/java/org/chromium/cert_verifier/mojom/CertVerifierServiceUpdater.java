package org.chromium.cert_verifier.mojom;

import org.chromium.mojo.bindings.Interface;

public interface CertVerifierServiceUpdater extends Interface {
  public static final Interface.Manager<CertVerifierServiceUpdater, Proxy> MANAGER =
      CertVerifierServiceUpdater_Internal.MANAGER;

  public interface Proxy extends CertVerifierServiceUpdater, Interface.Proxy {}

  void updateAdditionalCertificates(AdditionalCertificates additionalCertificates);
}
