package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.proxy_resolver.mojom.ProxyInfo;

public interface ProxyLookupClient extends Interface {
  public static final Interface.Manager<ProxyLookupClient, Proxy> MANAGER =
      ProxyLookupClient_Internal.MANAGER;

  public interface Proxy extends ProxyLookupClient, Interface.Proxy {}

  void onProxyLookupComplete(int i, ProxyInfo proxyInfo);
}
