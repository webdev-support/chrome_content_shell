package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class LockScreenServiceStatus {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;
  public static final int NOT_ALLOWED_FROM_CONTEXT = 1;
  public static final int SUCCESS = 0;
  public static final int WRITE_ERROR = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 2;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private LockScreenServiceStatus() {}
}
