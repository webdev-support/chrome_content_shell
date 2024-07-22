package org.chromium.ax.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class AriaCurrentState {
  public static final int DATE = 6;
  public static final int FALSE = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LOCATION = 5;
  public static final int MAX_VALUE = 7;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int PAGE = 3;
  public static final int STEP = 4;
  public static final int TIME = 7;
  public static final int TRUE = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 7;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private AriaCurrentState() {}
}
