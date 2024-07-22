package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ScreenOrientation extends Interface {
  public static final Interface.Manager<ScreenOrientation, Proxy> MANAGER =
      ScreenOrientation_Internal.MANAGER;

  public interface LockOrientation_Response {
    void call(int i);
  }

  public interface Proxy extends ScreenOrientation, Interface.Proxy {}

  void lockOrientation(int i, LockOrientation_Response lockOrientation_Response);

  void unlockOrientation();
}
