package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class QuotaStatusCode {
  public static final int ERROR_ABORT = 20;
  public static final int ERROR_INVALID_ACCESS = 15;
  public static final int ERROR_INVALID_MODIFICATION = 13;
  public static final int ERROR_NOT_SUPPORTED = 9;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 20;
  public static final int MIN_VALUE = -1;

  public static final int f453OK = 0;
  public static final int UNKNOWN = -1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    switch (value) {
      case -1:
      case 0:
      case 9:
      case 13:
      case 15:
      case 20:
        return true;
      default:
        return false;
    }
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private QuotaStatusCode() {}
}
