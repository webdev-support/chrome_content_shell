package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface NetworkChangeManagerClient extends Interface {
  public static final Interface.Manager<NetworkChangeManagerClient, Proxy> MANAGER =
      NetworkChangeManagerClient_Internal.MANAGER;

  public interface Proxy extends NetworkChangeManagerClient, Interface.Proxy {}

  void onInitialConnectionType(int i);

  void onNetworkChanged(int i);
}
