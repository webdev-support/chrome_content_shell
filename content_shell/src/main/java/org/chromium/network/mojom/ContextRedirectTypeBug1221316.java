package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ContextRedirectTypeBug1221316 {
  public static final int ALL_SAME_SITE_REDIRECT = 4;
  public static final int CROSS_SITE_REDIRECT = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int NO_REDIRECT = 1;
  public static final int PARTIAL_SAME_SITE_REDIRECT = 3;
  public static final int UNSET = 0;

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

  private ContextRedirectTypeBug1221316() {}
}
