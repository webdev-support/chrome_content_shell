package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.viz.mojom.SurfaceId;

public interface PictureInPictureSession extends Interface {
  public static final Interface.Manager<PictureInPictureSession, Proxy> MANAGER =
      PictureInPictureSession_Internal.MANAGER;

  public interface Proxy extends PictureInPictureSession, Interface.Proxy {}

  public interface Stop_Response {
    void call();
  }

  void stop(Stop_Response stop_Response);

  void update(
      int i,
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      SurfaceId surfaceId,
      Size size,
      boolean z);
}
