package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface FullscreenVideoElementHandler extends Interface {
  public static final Interface.Manager<FullscreenVideoElementHandler, Proxy> MANAGER =
      FullscreenVideoElementHandler_Internal.MANAGER;

  public interface Proxy extends FullscreenVideoElementHandler, Interface.Proxy {}

  void requestFullscreenVideoElement();
}
