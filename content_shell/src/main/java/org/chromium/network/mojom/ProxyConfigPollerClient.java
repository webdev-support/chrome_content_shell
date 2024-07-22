package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ProxyConfigPollerClient extends Interface {
  public static final Interface.Manager<ProxyConfigPollerClient, Proxy> MANAGER =
      ProxyConfigPollerClient_Internal.MANAGER;

  public interface Proxy extends ProxyConfigPollerClient, Interface.Proxy {}

  void onLazyProxyConfigPoll();
}
