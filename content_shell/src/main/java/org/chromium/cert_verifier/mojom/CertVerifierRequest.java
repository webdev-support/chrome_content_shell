package org.chromium.cert_verifier.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.network.mojom.CertVerifyResult;

public interface CertVerifierRequest extends Interface {
  public static final Interface.Manager<CertVerifierRequest, Proxy> MANAGER =
      CertVerifierRequest_Internal.MANAGER;

  public interface Proxy extends CertVerifierRequest, Interface.Proxy {}

  void complete(CertVerifyResult certVerifyResult, int i);
}
