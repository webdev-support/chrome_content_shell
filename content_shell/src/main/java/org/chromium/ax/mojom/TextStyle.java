package org.chromium.ax.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class TextStyle {
  public static final int BOLD = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int ITALIC = 2;
  public static final int LINE_THROUGH = 4;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int OVERLINE = 5;
  public static final int UNDERLINE = 3;

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

  private TextStyle() {}
}
