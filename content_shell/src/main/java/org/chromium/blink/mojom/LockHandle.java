package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface LockHandle extends Interface {
  public static final Interface.Manager<LockHandle, Proxy> MANAGER = LockHandle_Internal.MANAGER;

  public interface Proxy extends LockHandle, Interface.Proxy {}
}
