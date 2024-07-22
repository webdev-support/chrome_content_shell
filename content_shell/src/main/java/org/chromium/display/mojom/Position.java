package org.chromium.display.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class Position {
  public static final int BOTTOM = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LEFT = 3;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int RIGHT = 1;
  public static final int TOP = 0;

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

  private Position() {}
}
