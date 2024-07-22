package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class Hinting {
  public static final int FULL = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MEDIUM = 2;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int SLIGHT = 1;

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

  private Hinting() {}
}
