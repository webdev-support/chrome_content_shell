package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface WakeLockContext extends Interface {
  public static final Interface.Manager<WakeLockContext, Proxy> MANAGER =
      WakeLockContext_Internal.MANAGER;

  public interface Proxy extends WakeLockContext, Interface.Proxy {}

  void getWakeLock(int i, int i2, String str, InterfaceRequest<WakeLock> interfaceRequest);
}
