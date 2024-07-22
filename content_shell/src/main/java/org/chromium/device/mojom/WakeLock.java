package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface WakeLock extends Interface {
  public static final Interface.Manager<WakeLock, Proxy> MANAGER = WakeLock_Internal.MANAGER;

  public interface ChangeType_Response {
    void call(boolean z);
  }

  public interface HasWakeLockForTests_Response {
    void call(boolean z);
  }

  public interface Proxy extends WakeLock, Interface.Proxy {}

  void addClient(InterfaceRequest<WakeLock> interfaceRequest);

  void cancelWakeLock();

  void changeType(int i, ChangeType_Response changeType_Response);

  void hasWakeLockForTests(HasWakeLockForTests_Response hasWakeLockForTests_Response);

  void requestWakeLock();
}
