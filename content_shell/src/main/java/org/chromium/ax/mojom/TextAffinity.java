package org.chromium.ax.mojom;

public final class TextAffinity {
  public static final int DEFAULT_VALUE = 0;
  public static final int DOWNSTREAM = 1;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int UPSTREAM = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 2;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private TextAffinity() {}
}
