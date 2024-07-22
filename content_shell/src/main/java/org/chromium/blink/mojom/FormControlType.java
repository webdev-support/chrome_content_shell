package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class FormControlType {
  public static final int BUTTON_BUTTON = 0;
  public static final int BUTTON_POPOVER = 4;
  public static final int BUTTON_RESET = 2;
  public static final int BUTTON_SELECT_LIST = 3;
  public static final int BUTTON_SUBMIT = 1;
  public static final int FIELDSET = 5;
  public static final int INPUT_BUTTON = 6;
  public static final int INPUT_CHECKBOX = 7;
  public static final int INPUT_COLOR = 8;
  public static final int INPUT_DATE = 9;
  public static final int INPUT_DATETIME_LOCAL = 10;
  public static final int INPUT_EMAIL = 11;
  public static final int INPUT_FILE = 12;
  public static final int INPUT_HIDDEN = 13;
  public static final int INPUT_IMAGE = 14;
  public static final int INPUT_MONTH = 15;
  public static final int INPUT_NUMBER = 16;
  public static final int INPUT_PASSWORD = 17;
  public static final int INPUT_RADIO = 18;
  public static final int INPUT_RANGE = 19;
  public static final int INPUT_RESET = 20;
  public static final int INPUT_SEARCH = 21;
  public static final int INPUT_SUBMIT = 22;
  public static final int INPUT_TELEPHONE = 23;
  public static final int INPUT_TEXT = 24;
  public static final int INPUT_TIME = 25;
  public static final int INPUT_URL = 26;
  public static final int INPUT_WEEK = 27;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 32;
  public static final int MIN_VALUE = 0;
  public static final int OUTPUT = 28;
  public static final int SELECT_LIST = 31;
  public static final int SELECT_MULTIPLE = 30;
  public static final int SELECT_ONE = 29;
  public static final int TEXT_AREA = 32;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 32;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private FormControlType() {}
}
