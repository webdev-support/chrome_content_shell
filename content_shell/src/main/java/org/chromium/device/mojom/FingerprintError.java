package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class FingerprintError {
  public static final int CANCELED = 5;
  public static final int HW_UNAVAILABLE = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LOCKOUT = 7;
  public static final int MAX_VALUE = 8;
  public static final int MIN_VALUE = 0;
  public static final int NO_SPACE = 4;
  public static final int NO_TEMPLATES = 8;
  public static final int TIMEOUT = 3;
  public static final int UNABLE_TO_PROCESS = 2;
  public static final int UNABLE_TO_REMOVE = 6;
  public static final int UNKNOWN = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 8;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private FingerprintError() {}
}
