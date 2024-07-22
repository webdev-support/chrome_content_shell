package org.chromium.proxy_resolver.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface ProxyResolverFactory extends Interface {
  public static final Interface.Manager<ProxyResolverFactory, Proxy> MANAGER =
      ProxyResolverFactory_Internal.MANAGER;

  public interface Proxy extends ProxyResolverFactory, Interface.Proxy {}

  void createResolver(
      String str,
      InterfaceRequest<ProxyResolver> interfaceRequest,
      ProxyResolverFactoryRequestClient proxyResolverFactoryRequestClient);
}
