package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ProxyErrorClient extends Interface {
  public static final Interface.Manager<ProxyErrorClient, Proxy> MANAGER =
      ProxyErrorClient_Internal.MANAGER;

  public interface Proxy extends ProxyErrorClient, Interface.Proxy {}

  void onPacScriptError(int i, String str);

  void onRequestMaybeFailedDueToProxySettings(int i);
}
