package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.viz.mojom.SurfaceId;

public interface PictureInPictureService extends Interface {
  public static final Interface.Manager<PictureInPictureService, Proxy> MANAGER =
      PictureInPictureService_Internal.MANAGER;

  public interface Proxy extends PictureInPictureService, Interface.Proxy {}

  public interface StartSession_Response {
    void call(PictureInPictureSession pictureInPictureSession, Size size);
  }

  void startSession(
      int i,
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      SurfaceId surfaceId,
      Size size,
      boolean z,
      PictureInPictureSessionObserver pictureInPictureSessionObserver,
      Rect rect,
      StartSession_Response startSession_Response);
}
