package org.chromium.ui.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class BrowserColorVariant {
  public static final int EXPRESSIVE = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int NEUTRAL = 2;
  public static final int SYSTEM = 0;
  public static final int TONAL_SPOT = 1;
  public static final int VIBRANT = 3;

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

  private BrowserColorVariant() {}
}
