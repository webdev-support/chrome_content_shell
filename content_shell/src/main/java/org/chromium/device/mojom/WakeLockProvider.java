package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface WakeLockProvider extends Interface {
  public static final Interface.Manager<WakeLockProvider, Proxy> MANAGER =
      WakeLockProvider_Internal.MANAGER;

  public interface GetActiveWakeLocksForTests_Response {
    void call(int i);
  }

  public interface Proxy extends WakeLockProvider, Interface.Proxy {}

  void getActiveWakeLocksForTests(
      int i, GetActiveWakeLocksForTests_Response getActiveWakeLocksForTests_Response);

  void getWakeLockContextForId(int i, InterfaceRequest<WakeLockContext> interfaceRequest);

  void getWakeLockWithoutContext(
      int i, int i2, String str, InterfaceRequest<WakeLock> interfaceRequest);

  void notifyOnWakeLockDeactivation(int i, WakeLockObserver wakeLockObserver);
}
