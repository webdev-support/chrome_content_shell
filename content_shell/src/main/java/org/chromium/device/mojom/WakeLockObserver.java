package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface WakeLockObserver extends Interface {
  public static final Interface.Manager<WakeLockObserver, Proxy> MANAGER =
      WakeLockObserver_Internal.MANAGER;

  public interface Proxy extends WakeLockObserver, Interface.Proxy {}

  void onWakeLockDeactivated(int i);
}
