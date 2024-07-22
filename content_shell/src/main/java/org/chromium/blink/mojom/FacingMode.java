package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class FacingMode {
  public static final int ENVIRONMENT = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LEFT = 3;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int RIGHT = 4;
  public static final int USER = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 4;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private FacingMode() {}
}
