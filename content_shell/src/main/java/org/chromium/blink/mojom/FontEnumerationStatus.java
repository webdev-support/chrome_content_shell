package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class FontEnumerationStatus {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int NEEDS_USER_ACTIVATION = 3;
  public static final int NOT_VISIBLE = 4;

  public static final int f430OK = 0;
  public static final int PERMISSION_DENIED = 5;
  public static final int UNEXPECTED_ERROR = 2;
  public static final int UNIMPLEMENTED = 1;

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

  private FontEnumerationStatus() {}
}
