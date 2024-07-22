package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class BitrateAdjuster {
  private static final int FRAMERATE_ADJUSTMENT_BITRATE_ADJUSTMENT_FPS = 30;

  @Retention(RetentionPolicy.SOURCE)
  public @interface Type {
    public static final int FRAMERATE_ADJUSTMENT = 1;
    public static final int NO_ADJUSTMENT = 0;
  }

  BitrateAdjuster() {}

  public static int getTargetBitrate(int type, int bps, int frameRate) {
    switch (type) {
      case 0:
        return bps;
      case 1:
        if (frameRate == 0) {
          return bps;
        }
        return (bps * 30) / frameRate;
      default:
        return 0;
    }
  }

  public static int getInitialFrameRate(int type, int frameRateHint) {
    switch (type) {
      case 0:
        return Math.min(frameRateHint, 30);
      case 1:
        return 30;
      default:
        return 0;
    }
  }
}
