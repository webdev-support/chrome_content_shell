package org.chromium.ax.mojom;

public final class State {
  public static final int AUTOFILL_AVAILABLE = 1;
  public static final int COLLAPSED = 2;
  public static final int DEFAULT = 3;
  public static final int DEFAULT_VALUE = 0;
  public static final int EDITABLE = 4;
  public static final int EXPANDED = 5;
  public static final int FOCUSABLE = 6;
  public static final int HORIZONTAL = 7;
  public static final int HOVERED = 8;
  public static final int IGNORED = 9;
  public static final int INVISIBLE = 10;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int LINKED = 11;
  public static final int MAX_VALUE = 18;
  public static final int MIN_VALUE = 0;
  public static final int MULTILINE = 12;
  public static final int MULTISELECTABLE = 13;
  public static final int NONE = 0;
  public static final int PROTECTED = 14;
  public static final int REQUIRED = 15;
  public static final int RICHLY_EDITABLE = 16;
  public static final int VERTICAL = 17;
  public static final int VISITED = 18;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 18;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private State() {}
}
