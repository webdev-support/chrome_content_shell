package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ScreenOrientationListener extends Interface {
  public static final Interface.Manager<ScreenOrientationListener, Proxy> MANAGER =
      ScreenOrientationListener_Internal.MANAGER;

  public interface IsAutoRotateEnabledByUser_Response {
    void call(boolean z);
  }

  public interface Proxy extends ScreenOrientationListener, Interface.Proxy {}

  void isAutoRotateEnabledByUser(
      IsAutoRotateEnabledByUser_Response isAutoRotateEnabledByUser_Response);
}
