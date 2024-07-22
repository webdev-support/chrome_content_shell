package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SslConfigClient extends Interface {
  public static final Interface.Manager<SslConfigClient, Proxy> MANAGER =
      SslConfigClient_Internal.MANAGER;

  public interface Proxy extends SslConfigClient, Interface.Proxy {}

  void onSslConfigUpdated(SslConfig sslConfig);
}
