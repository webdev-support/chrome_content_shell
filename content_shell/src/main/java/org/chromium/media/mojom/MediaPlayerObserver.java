package org.chromium.media.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.media_session.mojom.MediaPosition;
import org.chromium.media_session.mojom.RemotePlaybackMetadata;
import org.chromium.mojo.bindings.Interface;

public interface MediaPlayerObserver extends Interface {
  public static final Interface.Manager<MediaPlayerObserver, Proxy> MANAGER =
      MediaPlayerObserver_Internal.MANAGER;

  public interface Proxy extends MediaPlayerObserver, Interface.Proxy {}

  void onAudioOutputSinkChanged(String str);

  void onAudioOutputSinkChangingDisabled();

  void onMediaEffectivelyFullscreenChanged(int i);

  void onMediaMetadataChanged(boolean z, boolean z2, int i);

  void onMediaPaused(boolean z);

  void onMediaPlaying();

  void onMediaPositionStateChanged(MediaPosition mediaPosition);

  void onMediaSizeChanged(Size size);

  void onMutedStatusChanged(boolean z);

  void onPictureInPictureAvailabilityChanged(boolean z);

  void onRemotePlaybackMetadataChange(RemotePlaybackMetadata remotePlaybackMetadata);

  void onUseAudioServiceChanged(boolean z);
}
