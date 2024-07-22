package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class NdefErrorType {
  public static final int INVALID_MESSAGE = 3;
  public static final int IO_ERROR = 5;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int NOT_ALLOWED = 0;
  public static final int NOT_READABLE = 2;
  public static final int NOT_SUPPORTED = 1;
  public static final int OPERATION_CANCELLED = 4;

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

  private NdefErrorType() {}
}
