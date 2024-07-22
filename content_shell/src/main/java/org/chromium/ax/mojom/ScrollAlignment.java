package org.chromium.ax.mojom;

public final class ScrollAlignment {
  public static final int DEFAULT_VALUE = 0;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 6;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int SCROLL_ALIGNMENT_BOTTOM = 3;
  public static final int SCROLL_ALIGNMENT_CENTER = 1;
  public static final int SCROLL_ALIGNMENT_CLOSEST_EDGE = 6;
  public static final int SCROLL_ALIGNMENT_LEFT = 4;
  public static final int SCROLL_ALIGNMENT_RIGHT = 5;
  public static final int SCROLL_ALIGNMENT_TOP = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 6;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private ScrollAlignment() {}
}
