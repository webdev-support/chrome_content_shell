package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class HandwritingGestureResult {
  public static final int CANCELLED = 4;
  public static final int FAILED = 3;
  public static final int FALLBACK = 5;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int SUCCESS = 1;
  public static final int UNKNOWN = 0;
  public static final int UNSUPPORTED = 2;

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

  private HandwritingGestureResult() {}
}
