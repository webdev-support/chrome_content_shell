package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class FocusType {
  public static final int ACCESS_KEY = 6;
  public static final int BACKWARD = 3;
  public static final int FORWARD = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 7;
  public static final int MIN_VALUE = 0;
  public static final int MOUSE = 5;
  public static final int NONE = 0;
  public static final int PAGE = 7;
  public static final int SCRIPT = 1;
  public static final int SPATIAL_NAVIGATION = 4;

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

  private FocusType() {}
}
