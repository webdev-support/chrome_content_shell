package org.chromium.ui.mojom;

public final class WindowShowState {
  public static final int DEFAULT_VALUE = 0;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int SHOW_STATE_DEFAULT = 0;
  public static final int SHOW_STATE_FULLSCREEN = 5;
  public static final int SHOW_STATE_INACTIVE = 4;
  public static final int SHOW_STATE_MAXIMIZED = 3;
  public static final int SHOW_STATE_MINIMIZED = 2;
  public static final int SHOW_STATE_NORMAL = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 5;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private WindowShowState() {}
}
