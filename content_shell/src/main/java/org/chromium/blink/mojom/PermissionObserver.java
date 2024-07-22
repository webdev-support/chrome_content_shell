package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PermissionObserver extends Interface {
  public static final Interface.Manager<PermissionObserver, Proxy> MANAGER =
      PermissionObserver_Internal.MANAGER;

  public interface Proxy extends PermissionObserver, Interface.Proxy {}

  void onPermissionStatusChange(int i);
}
