package org.chromium.display.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ScreenOrientation {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LANDSCAPE_PRIMARY = 3;
  public static final int LANDSCAPE_SECONDARY = 4;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int PORTRAIT_PRIMARY = 1;
  public static final int PORTRAIT_SECONDARY = 2;
  public static final int UNDEFINED = 0;

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

  private ScreenOrientation() {}
}
