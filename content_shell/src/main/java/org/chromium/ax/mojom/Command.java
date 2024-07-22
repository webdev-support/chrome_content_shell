package org.chromium.ax.mojom;

public final class Command {
  public static final int CLEAR_SELECTION = 1;
  public static final int DEFAULT_VALUE = 0;
  public static final int DELETE = 2;
  public static final int DICTATE = 3;
  public static final int EXTEND_SELECTION = 4;
  public static final int FORMAT = 5;
  public static final int HISTORY = 6;
  public static final int INSERT = 7;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MARKER = 8;
  public static final int MAX_VALUE = 10;
  public static final int MIN_VALUE = 0;
  public static final int MOVE_SELECTION = 9;
  public static final int NONE = 0;
  public static final int SET_SELECTION = 10;

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

  private Command() {}
}
