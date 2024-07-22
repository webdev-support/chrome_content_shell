package org.chromium.ui.mojom;

public final class MenuSourceType {
  public static final int ADJUST_SELECTION = 9;
  public static final int ADJUST_SELECTION_RESET = 10;
  public static final int DEFAULT_VALUE = 0;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int KEYBOARD = 2;
  public static final int LONG_PRESS = 5;
  public static final int LONG_TAP = 6;
  public static final int MAX_VALUE = 10;
  public static final int MIN_VALUE = 0;
  public static final int MOUSE = 1;
  public static final int NONE = 0;
  public static final int STYLUS = 8;
  public static final int TOUCH = 3;
  public static final int TOUCH_EDIT_MENU = 4;
  public static final int TOUCH_HANDLE = 7;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 10;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private MenuSourceType() {}
}
