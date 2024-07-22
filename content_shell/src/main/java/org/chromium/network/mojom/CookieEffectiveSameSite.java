package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CookieEffectiveSameSite {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LAX_MODE = 1;
  public static final int LAX_MODE_ALLOW_UNSAFE = 3;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int NO_RESTRICTION = 0;
  public static final int STRICT_MODE = 2;
  public static final int UNDEFINED = 4;

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

  private CookieEffectiveSameSite() {}
}