package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface P2pTrustedSocketManager extends Interface {
  public static final Interface.Manager<P2pTrustedSocketManager, Proxy> MANAGER =
      P2pTrustedSocketManager_Internal.MANAGER;

  public interface Proxy extends P2pTrustedSocketManager, Interface.Proxy {}

  void pauseNetworkChangeNotifications();

  void resumeNetworkChangeNotifications();

  void startRtpDump(boolean z, boolean z2);

  void stopRtpDump(boolean z, boolean z2);
}
