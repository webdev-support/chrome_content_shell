package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PointerLockContext extends Interface {
  public static final Interface.Manager<PointerLockContext, Proxy> MANAGER =
      PointerLockContext_Internal.MANAGER;

  public interface Proxy extends PointerLockContext, Interface.Proxy {}

  public interface RequestMouseLockChange_Response {
    void call(int i);
  }

  void requestMouseLockChange(
      boolean z, RequestMouseLockChange_Response requestMouseLockChange_Response);
}
