package org.chromium.proxy_resolver.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.network.mojom.NetworkAnonymizationKey;
import org.chromium.url.mojom.Url;

public interface ProxyResolver extends Interface {
  public static final Interface.Manager<ProxyResolver, Proxy> MANAGER =
      ProxyResolver_Internal.MANAGER;

  public interface Proxy extends ProxyResolver, Interface.Proxy {}

  void getProxyForUrl(
      Url url,
      NetworkAnonymizationKey networkAnonymizationKey,
      ProxyResolverRequestClient proxyResolverRequestClient);
}
