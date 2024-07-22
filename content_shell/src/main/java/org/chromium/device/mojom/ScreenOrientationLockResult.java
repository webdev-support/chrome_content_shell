package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ScreenOrientationLockResult {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int SCREEN_ORIENTATION_LOCK_RESULT_ERROR_CANCELED = 3;
  public static final int SCREEN_ORIENTATION_LOCK_RESULT_ERROR_FULLSCREEN_REQUIRED = 2;
  public static final int SCREEN_ORIENTATION_LOCK_RESULT_ERROR_NOT_AVAILABLE = 1;
  public static final int SCREEN_ORIENTATION_LOCK_RESULT_SUCCESS = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 3;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private ScreenOrientationLockResult() {}
}
