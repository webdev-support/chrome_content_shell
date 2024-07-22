package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface WebTransportHandshakeClient extends Interface {
  public static final Interface.Manager<WebTransportHandshakeClient, Proxy> MANAGER =
      WebTransportHandshakeClient_Internal.MANAGER;

  public interface Proxy extends WebTransportHandshakeClient, Interface.Proxy {}

  void onConnectionEstablished(
      WebTransport webTransport,
      InterfaceRequest<WebTransportClient> interfaceRequest,
      HttpResponseHeaders httpResponseHeaders,
      WebTransportStats webTransportStats);

  void onHandshakeFailed(WebTransportError webTransportError);
}
