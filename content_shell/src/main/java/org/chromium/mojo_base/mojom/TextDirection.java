package org.chromium.mojo_base.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class TextDirection {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LEFT_TO_RIGHT = 2;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;
  public static final int RIGHT_TO_LEFT = 1;
  public static final int UNKNOWN_DIRECTION = 0;

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

  private TextDirection() {}
}
