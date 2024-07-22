package org.chromium.ax.mojom;

public final class MoveDirection {
  public static final int BACKWARD = 1;
  public static final int DEFAULT_VALUE = 0;
  public static final int FORWARD = 2;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;

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

  private MoveDirection() {}
}
