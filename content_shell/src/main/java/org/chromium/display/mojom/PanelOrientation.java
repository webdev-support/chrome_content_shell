package org.chromium.display.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class PanelOrientation {
  public static final int BOTTOM_UP = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LEFT_UP = 2;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int NORMAL = 0;
  public static final int RIGHT_UP = 3;

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

  private PanelOrientation() {}
}
