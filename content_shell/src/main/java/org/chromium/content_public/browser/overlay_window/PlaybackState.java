package org.chromium.content_public.browser.overlay_window;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface PlaybackState {
  public static final int END_OF_VIDEO = 2;
  public static final int PAUSED = 1;
  public static final int PLAYING = 0;
}
