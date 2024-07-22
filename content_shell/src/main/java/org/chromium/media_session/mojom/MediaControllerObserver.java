package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface MediaControllerObserver extends Interface {
  public static final Interface.Manager<MediaControllerObserver, Proxy> MANAGER =
      MediaControllerObserver_Internal.MANAGER;

  public interface Proxy extends MediaControllerObserver, Interface.Proxy {}

  void mediaSessionActionsChanged(int[] iArr);

  void mediaSessionChanged(UnguessableToken unguessableToken);

  void mediaSessionInfoChanged(MediaSessionInfo mediaSessionInfo);

  void mediaSessionMetadataChanged(MediaMetadata mediaMetadata);

  void mediaSessionPositionChanged(MediaPosition mediaPosition);
}
