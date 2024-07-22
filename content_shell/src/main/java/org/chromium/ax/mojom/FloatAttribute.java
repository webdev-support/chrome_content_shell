package org.chromium.ax.mojom;

public final class FloatAttribute {
  public static final int CHILD_TREE_SCALE = 8;
  public static final int DEFAULT_VALUE = 0;
  public static final int FONT_SIZE = 5;
  public static final int FONT_WEIGHT = 6;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 8;
  public static final int MAX_VALUE_FOR_RANGE = 3;
  public static final int MIN_VALUE = 0;
  public static final int MIN_VALUE_FOR_RANGE = 2;
  public static final int NONE = 0;
  public static final int STEP_VALUE_FOR_RANGE = 4;
  public static final int TEXT_INDENT = 7;
  public static final int VALUE_FOR_RANGE = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 8;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private FloatAttribute() {}
}
