package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface CloseListener extends Interface {
  public static final Interface.Manager<CloseListener, Proxy> MANAGER =
      CloseListener_Internal.MANAGER;

  public interface Proxy extends CloseListener, Interface.Proxy {}

  void signal();
}
