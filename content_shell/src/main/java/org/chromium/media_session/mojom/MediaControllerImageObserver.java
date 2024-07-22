package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.Interface;

public interface MediaControllerImageObserver extends Interface {
  public static final Interface.Manager<MediaControllerImageObserver, Proxy> MANAGER =
      MediaControllerImageObserver_Internal.MANAGER;

  public interface Proxy extends MediaControllerImageObserver, Interface.Proxy {}

  void mediaControllerImageChanged(int i, MediaImageBitmap mediaImageBitmap);
}
