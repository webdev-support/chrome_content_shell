package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class Button {
  public static final int BACK = 3;
  public static final int BARREL = 2;
  public static final int ERASER = 5;
  public static final int FORWARD = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LEFT = 0;
  public static final int MAX_VALUE = 5;
  public static final int MIDDLE = 1;
  public static final int MIN_VALUE = -1;
  public static final int NO_BUTTON = -1;
  public static final int RIGHT = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= -1 && value <= 5;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private Button() {}
}
