package org.chromium.ax.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class TextDecorationStyle {
  public static final int DASHED = 2;
  public static final int DOTTED = 1;
  public static final int DOUBLE = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int SOLID = 3;
  public static final int WAVY = 5;

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

  private TextDecorationStyle() {}
}
