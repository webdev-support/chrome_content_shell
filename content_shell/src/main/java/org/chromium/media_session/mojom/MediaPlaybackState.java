package org.chromium.media_session.mojom;

public final class MediaPlaybackState {
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 1;
  public static final int MIN_VALUE = 0;
  public static final int PAUSED = 0;
  public static final int PLAYING = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 1;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    return value;
  }

  private MediaPlaybackState() {}
}
