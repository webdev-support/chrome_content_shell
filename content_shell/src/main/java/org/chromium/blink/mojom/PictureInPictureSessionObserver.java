package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;

public interface PictureInPictureSessionObserver extends Interface {
  public static final Interface.Manager<PictureInPictureSessionObserver, Proxy> MANAGER =
      PictureInPictureSessionObserver_Internal.MANAGER;

  public interface Proxy extends PictureInPictureSessionObserver, Interface.Proxy {}

  void onStopped();

  void onWindowSizeChanged(Size size);
}
