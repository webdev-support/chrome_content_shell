package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CorsOriginAccessMatchPriority {
  public static final int DEFAULT_PRIORITY = 1;
  public static final int HIGH_PRIORITY = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LOW_PRIORITY = 2;
  public static final int MAX_PRIORITY = 5;
  public static final int MAX_VALUE = 5;
  public static final int MEDIUM_PRIORITY = 3;
  public static final int MIN_VALUE = 0;
  public static final int NO_MATCHING_ORIGIN = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 5;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private CorsOriginAccessMatchPriority() {}
}
