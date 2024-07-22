package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class Modifier {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 3;
  public static final int ONE_OR_MORE = 2;
  public static final int OPTIONAL = 1;
  public static final int ZERO_OR_MORE = 0;

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

  private Modifier() {}
}
