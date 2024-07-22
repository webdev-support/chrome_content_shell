package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class HoverType {
  public static final int HOVER_FIRST_TYPE = 1;
  public static final int HOVER_HOVER_TYPE = 2;
  public static final int HOVER_NONE = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 1 && value <= 2;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private HoverType() {}
}
