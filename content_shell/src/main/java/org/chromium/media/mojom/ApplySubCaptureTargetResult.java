package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ApplySubCaptureTargetResult {
  public static final int ERROR_GENERIC = 1;
  public static final int INVALID_TARGET = 5;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int NON_INCREASING_VERSION = 4;
  public static final int NOT_IMPLEMENTED = 3;
  public static final int SUCCESS = 0;
  public static final int UNSUPPORTED_CAPTURE_DEVICE = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 5;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private ApplySubCaptureTargetResult() {}
}
