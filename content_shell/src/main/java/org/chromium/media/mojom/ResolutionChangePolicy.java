package org.chromium.media.mojom;

public final class ResolutionChangePolicy {
  public static final int ANY_WITHIN_LIMIT = 2;
  public static final int FIXED_ASPECT_RATIO = 1;
  public static final int FIXED_RESOLUTION = 0;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 2;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    return value;
  }

  private ResolutionChangePolicy() {}
}
