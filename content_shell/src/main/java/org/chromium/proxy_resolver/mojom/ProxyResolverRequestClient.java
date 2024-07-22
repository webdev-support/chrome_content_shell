package org.chromium.proxy_resolver.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.network.mojom.NetworkAnonymizationKey;

public interface ProxyResolverRequestClient extends Interface {
  public static final Interface.Manager<ProxyResolverRequestClient, Proxy> MANAGER =
      ProxyResolverRequestClient_Internal.MANAGER;

  public interface Proxy extends ProxyResolverRequestClient, Interface.Proxy {}

  void alert(String str);

  void onError(int i, String str);

  void reportResult(int i, ProxyInfo proxyInfo);

  void resolveDns(
      String str,
      int i,
      NetworkAnonymizationKey networkAnonymizationKey,
      HostResolverRequestClient hostResolverRequestClient);
}
