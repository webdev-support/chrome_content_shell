package org.chromium.ax.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class TextAlign {
  public static final int CENTER = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int JUSTIFY = 4;
  public static final int LEFT = 1;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int RIGHT = 2;

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

  private TextAlign() {}
}
