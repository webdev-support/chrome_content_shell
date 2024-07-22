package org.chromium.content_public.browser;

import org.chromium.base.ObserverList;
import org.chromium.content.browser.MediaSessionImpl;

public abstract class MediaSession {
  public abstract void didReceiveAction(int i);

  public abstract ObserverList.RewindableIterator<MediaSessionObserver> getObserversForTesting();

  public abstract boolean isControllable();

  public abstract void requestSystemAudioFocus();

  public abstract void resume();

  public abstract void seek(long j);

  public abstract void seekTo(long j);

  public abstract void stop();

  public abstract void suspend();

  public static MediaSession fromWebContents(WebContents contents) {
    return MediaSessionImpl.fromWebContents(contents);
  }
}
