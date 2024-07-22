package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ClientCertificateResponder extends Interface {
  public static final Interface.Manager<ClientCertificateResponder, Proxy> MANAGER =
      ClientCertificateResponder_Internal.MANAGER;

  public interface Proxy extends ClientCertificateResponder, Interface.Proxy {}

  void cancelRequest();

  void continueWithCertificate(
      X509Certificate x509Certificate, String str, short[] sArr, SslPrivateKey sslPrivateKey);

  void continueWithoutCertificate();
}
