package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface NetworkChangeManager extends Interface {
  public static final Interface.Manager<NetworkChangeManager, Proxy> MANAGER =
      NetworkChangeManager_Internal.MANAGER;

  public interface Proxy extends NetworkChangeManager, Interface.Proxy {}

  void onNetworkChanged(boolean z, boolean z2, boolean z3, int i, boolean z4, int i2);

  void requestNotifications(NetworkChangeManagerClient networkChangeManagerClient);
}
