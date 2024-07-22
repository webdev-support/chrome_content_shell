package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface NonPersistentNotificationListener extends Interface {
  public static final Interface.Manager<NonPersistentNotificationListener, Proxy> MANAGER =
      NonPersistentNotificationListener_Internal.MANAGER;

  public interface OnClick_Response {
    void call();
  }

  public interface OnClose_Response {
    void call();
  }

  public interface Proxy extends NonPersistentNotificationListener, Interface.Proxy {}

  void onClick(OnClick_Response onClick_Response);

  void onClose(OnClose_Response onClose_Response);

  void onShow();
}
