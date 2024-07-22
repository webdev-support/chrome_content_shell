package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface KeyboardLockService extends Interface {
  public static final Interface.Manager<KeyboardLockService, Proxy> MANAGER =
      KeyboardLockService_Internal.MANAGER;

  public interface GetKeyboardLayoutMap_Response {
    void call(GetKeyboardLayoutMapResult getKeyboardLayoutMapResult);
  }

  public interface Proxy extends KeyboardLockService, Interface.Proxy {}

  public interface RequestKeyboardLock_Response {
    void call(int i);
  }

  void cancelKeyboardLock();

  void getKeyboardLayoutMap(GetKeyboardLayoutMap_Response getKeyboardLayoutMap_Response);

  void requestKeyboardLock(
      String[] strArr, RequestKeyboardLock_Response requestKeyboardLock_Response);
}
