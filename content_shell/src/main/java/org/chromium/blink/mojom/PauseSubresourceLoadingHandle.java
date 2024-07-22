package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PauseSubresourceLoadingHandle extends Interface {
  public static final Interface.Manager<PauseSubresourceLoadingHandle, Proxy> MANAGER =
      PauseSubresourceLoadingHandle_Internal.MANAGER;

  public interface Proxy extends PauseSubresourceLoadingHandle, Interface.Proxy {}
}
