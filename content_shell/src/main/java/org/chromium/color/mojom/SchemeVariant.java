package org.chromium.color.mojom;

public final class SchemeVariant {
  public static final int DEFAULT_VALUE = 0;
  public static final int EXPRESSIVE = 3;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int NEUTRAL = 1;
  public static final int TONAL_SPOT = 0;
  public static final int VIBRANT = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 3;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private SchemeVariant() {}
}
