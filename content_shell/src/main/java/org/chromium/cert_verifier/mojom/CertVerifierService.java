package org.chromium.cert_verifier.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.network.mojom.NetLogSource;
import org.chromium.network.mojom.UrlLoaderFactory;

public interface CertVerifierService extends Interface {
  public static final Interface.Manager<CertVerifierService, Proxy> MANAGER =
      CertVerifierService_Internal.MANAGER;

  public interface Proxy extends CertVerifierService, Interface.Proxy {}

  void enableNetworkAccess(
      UrlLoaderFactory urlLoaderFactory, UrlLoaderFactoryConnector urlLoaderFactoryConnector);

  void setConfig(CertVerifierConfig certVerifierConfig);

  void verify(
      RequestParams requestParams,
      NetLogSource netLogSource,
      CertVerifierRequest certVerifierRequest);
}
