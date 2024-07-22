package org.chromium.device.mojom;

public final class WakeLockReason {
  public static final int AUDIO_PLAYBACK = 0;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;
  public static final int OTHER = 2;
  public static final int VIDEO_PLAYBACK = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 2;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    return value;
  }

  private WakeLockReason() {}
}
