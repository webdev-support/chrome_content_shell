package org.chromium.blink.mojom;

import org.chromium.media_session.mojom.MediaPosition;
import org.chromium.mojo.bindings.Interface;

public interface MediaSessionService extends Interface {
  public static final Interface.Manager<MediaSessionService, Proxy> MANAGER =
      MediaSessionService_Internal.MANAGER;

  public interface Proxy extends MediaSessionService, Interface.Proxy {}

  void disableAction(int i);

  void enableAction(int i);

  void setCameraState(int i);

  void setClient(MediaSessionClient mediaSessionClient);

  void setMetadata(SpecMediaMetadata specMediaMetadata);

  void setMicrophoneState(int i);

  void setPlaybackState(int i);

  void setPositionState(MediaPosition mediaPosition);
}
