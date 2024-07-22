package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface CustomProxyConnectionObserver extends Interface {
  public static final Interface.Manager<CustomProxyConnectionObserver, Proxy> MANAGER =
      CustomProxyConnectionObserver_Internal.MANAGER;

  public interface Proxy extends CustomProxyConnectionObserver, Interface.Proxy {}

  void onFallback(ProxyChain proxyChain, int i);

  void onTunnelHeadersReceived(
      ProxyChain proxyChain, long j, HttpResponseHeaders httpResponseHeaders);
}
