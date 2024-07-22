package org.chromium.ui.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class WindowOpenDisposition {
  public static final int CURRENT_TAB = 1;
  public static final int IGNORE_ACTION = 9;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 11;
  public static final int MIN_VALUE = 0;
  public static final int NEW_BACKGROUND_TAB = 4;
  public static final int NEW_FOREGROUND_TAB = 3;
  public static final int NEW_PICTURE_IN_PICTURE = 11;
  public static final int NEW_POPUP = 5;
  public static final int NEW_WINDOW = 6;
  public static final int OFF_THE_RECORD = 8;
  public static final int SAVE_TO_DISK = 7;
  public static final int SINGLETON_TAB = 2;
  public static final int SWITCH_TO_TAB = 10;
  public static final int UNKNOWN = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 11;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private WindowOpenDisposition() {}
}
