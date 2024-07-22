package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CapturedSurfaceControlResult {
  public static final int CAPTURED_SURFACE_NOT_FOUND_ERROR = 4;
  public static final int CAPTURER_NOT_FOCUSED_ERROR = 6;
  public static final int CAPTURER_NOT_FOUND_ERROR = 3;
  public static final int DISALLOWED_FOR_SELF_CAPTURE_ERROR = 5;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 6;
  public static final int MIN_VALUE = 0;
  public static final int NO_PERMISSION_ERROR = 2;
  public static final int SUCCESS = 0;
  public static final int UNKNOWN_ERROR = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 6;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private CapturedSurfaceControlResult() {}
}
