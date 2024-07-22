package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ProxyConfigClient extends Interface {
  public static final Interface.Manager<ProxyConfigClient, Proxy> MANAGER =
      ProxyConfigClient_Internal.MANAGER;

  public interface FlushProxyConfig_Response {
    void call();
  }

  public interface Proxy extends ProxyConfigClient, Interface.Proxy {}

  void flushProxyConfig(FlushProxyConfig_Response flushProxyConfig_Response);

  void onProxyConfigUpdated(ProxyConfigWithAnnotation proxyConfigWithAnnotation);
}
