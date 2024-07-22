package org.chromium.ax.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class HasPopup {
  public static final int DIALOG = 6;
  public static final int FALSE = 0;
  public static final int GRID = 5;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LISTBOX = 3;
  public static final int MAX_VALUE = 6;
  public static final int MENU = 2;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int TREE = 4;
  public static final int TRUE = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 6;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private HasPopup() {}
}
