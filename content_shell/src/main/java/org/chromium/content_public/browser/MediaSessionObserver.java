package org.chromium.content_public.browser;

import java.util.List;
import java.util.Set;
import org.chromium.content.browser.MediaSessionImpl;
import org.chromium.services.media_session.MediaImage;
import org.chromium.services.media_session.MediaMetadata;
import org.chromium.services.media_session.MediaPosition;

public abstract class MediaSessionObserver {
  private MediaSessionImpl mMediaSession;

  protected MediaSessionObserver(MediaSession mediaSession) {
    if (mediaSession instanceof MediaSessionImpl) {
      MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) mediaSession;
      this.mMediaSession = mediaSessionImpl;
      mediaSessionImpl.addObserver(this);
    }
  }

  public final MediaSession getMediaSession() {
    return this.mMediaSession;
  }

  public void mediaSessionDestroyed() {}

  public void mediaSessionStateChanged(boolean isControllable, boolean isSuspended) {}

  public void mediaSessionMetadataChanged(MediaMetadata metadata) {}

  public void mediaSessionActionsChanged(Set<Integer> actions) {}

  public void mediaSessionArtworkChanged(List<MediaImage> images) {}

  public void mediaSessionPositionChanged(MediaPosition position) {}

  public final void stopObserving() {
    MediaSessionImpl mediaSessionImpl = this.mMediaSession;
    if (mediaSessionImpl == null) {
      return;
    }
    mediaSessionImpl.removeObserver(this);
    this.mMediaSession = null;
  }
}
