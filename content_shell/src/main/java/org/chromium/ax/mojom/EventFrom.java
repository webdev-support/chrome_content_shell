package org.chromium.ax.mojom;

public final class EventFrom {
  public static final int ACTION = 3;
  public static final int DEFAULT_VALUE = 0;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int PAGE = 2;
  public static final int USER = 1;

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

  private EventFrom() {}
}
