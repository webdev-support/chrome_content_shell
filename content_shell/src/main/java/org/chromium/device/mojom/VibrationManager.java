package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface VibrationManager extends Interface {
  public static final Interface.Manager<VibrationManager, Proxy> MANAGER =
      VibrationManager_Internal.MANAGER;

  public interface Cancel_Response {
    void call();
  }

  public interface Proxy extends VibrationManager, Interface.Proxy {}

  public interface Vibrate_Response {
    void call();
  }

  void cancel(Cancel_Response cancel_Response);

  void vibrate(long j, Vibrate_Response vibrate_Response);
}
