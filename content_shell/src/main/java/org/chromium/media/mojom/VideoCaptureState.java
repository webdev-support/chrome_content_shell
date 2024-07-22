package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class VideoCaptureState {
  public static final int ENDED = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int PAUSED = 1;
  public static final int RESUMED = 2;
  public static final int STARTED = 0;
  public static final int STOPPED = 3;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 4;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private VideoCaptureState() {}
}
