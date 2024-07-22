package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.network.mojom.WebTransportCertificateFingerprint;
import org.chromium.network.mojom.WebTransportHandshakeClient;
import org.chromium.url.mojom.Url;

public interface WebTransportConnector extends Interface {
  public static final Interface.Manager<WebTransportConnector, Proxy> MANAGER =
      WebTransportConnector_Internal.MANAGER;

  public interface Proxy extends WebTransportConnector, Interface.Proxy {}

  void connect(
      Url url,
      WebTransportCertificateFingerprint[] webTransportCertificateFingerprintArr,
      WebTransportHandshakeClient webTransportHandshakeClient);
}
