package org.chromium.display.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class Rotation {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int VALUE_0 = 0;
  public static final int VALUE_180 = 2;
  public static final int VALUE_270 = 3;
  public static final int VALUE_90 = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 3;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private Rotation() {}
}
