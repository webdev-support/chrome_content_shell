package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class SmsStatus {
  public static final int ABORTED = 3;
  public static final int BACKEND_NOT_AVAILABLE = 5;
  public static final int CANCELLED = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int SUCCESS = 0;
  public static final int TIMEOUT = 4;
  public static final int UNHANDLED_REQUEST = 1;

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

  private SmsStatus() {}
}
