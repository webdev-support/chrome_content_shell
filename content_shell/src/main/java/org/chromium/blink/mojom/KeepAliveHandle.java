package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface KeepAliveHandle extends Interface {
  public static final Interface.Manager<KeepAliveHandle, Proxy> MANAGER =
      KeepAliveHandle_Internal.MANAGER;

  public interface Proxy extends KeepAliveHandle, Interface.Proxy {}
}
