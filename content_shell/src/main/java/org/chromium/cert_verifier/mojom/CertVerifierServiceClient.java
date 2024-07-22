package org.chromium.cert_verifier.mojom;

import org.chromium.mojo.bindings.Interface;

public interface CertVerifierServiceClient extends Interface {
  public static final Interface.Manager<CertVerifierServiceClient, Proxy> MANAGER =
      CertVerifierServiceClient_Internal.MANAGER;

  public interface Proxy extends CertVerifierServiceClient, Interface.Proxy {}

  void onCertVerifierChanged();
}
