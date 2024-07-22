package org.chromium.ax.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ListStyle {
  public static final int CIRCLE = 1;
  public static final int DISC = 2;
  public static final int IMAGE = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 6;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int NUMERIC = 4;
  public static final int OTHER = 6;
  public static final int SQUARE = 5;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 6;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private ListStyle() {}
}
