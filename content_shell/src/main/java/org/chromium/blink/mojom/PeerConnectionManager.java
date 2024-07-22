package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PeerConnectionManager extends Interface {
  public static final Interface.Manager<PeerConnectionManager, Proxy> MANAGER =
      PeerConnectionManager_Internal.MANAGER;

  public interface Proxy extends PeerConnectionManager, Interface.Proxy {}

  void getCurrentState();

  void getStandardStats();

  void onSpeedLimitChange(int i);

  void onSuspend();

  void onThermalStateChange(int i);

  void startEventLog(int i, int i2);

  void stopEventLog(int i);
}
