package org.chromium.skia.mojom;

public final class ColorType {
  public static final int ALPHA_8 = 1;
  public static final int ARGB_4444 = 3;
  public static final int BGRA_8888 = 5;
  public static final int DEFAULT_VALUE = 0;
  public static final int DEPRECATED_INDEX_8 = 6;
  public static final int GRAY_8 = 7;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 7;
  public static final int MIN_VALUE = 0;
  public static final int RGBA_8888 = 4;
  public static final int RGB_565 = 2;
  public static final int UNKNOWN = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 7;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private ColorType() {}
}
