package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CorsPreflightPolicy {
  public static final int CONSIDER_PREFLIGHT = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 1;
  public static final int MIN_VALUE = 0;
  public static final int PREVENT_PREFLIGHT = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 1;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private CorsPreflightPolicy() {}
}
