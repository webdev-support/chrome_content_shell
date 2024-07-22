package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface CustomProxyConfigClient extends Interface {
  public static final Interface.Manager<CustomProxyConfigClient, Proxy> MANAGER =
      CustomProxyConfigClient_Internal.MANAGER;

  public interface OnCustomProxyConfigUpdated_Response {
    void call();
  }

  public interface Proxy extends CustomProxyConfigClient, Interface.Proxy {}

  void onCustomProxyConfigUpdated(
      CustomProxyConfig customProxyConfig,
      OnCustomProxyConfigUpdated_Response onCustomProxyConfigUpdated_Response);
}
