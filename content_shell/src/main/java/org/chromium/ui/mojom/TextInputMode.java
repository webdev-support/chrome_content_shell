package org.chromium.ui.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class TextInputMode {
  public static final int DECIMAL = 7;
  public static final int DEFAULT = 0;
  public static final int EMAIL = 5;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 8;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 1;
  public static final int NUMERIC = 6;
  public static final int SEARCH = 8;
  public static final int TEL = 3;
  public static final int TEXT = 2;
  public static final int URL = 4;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 8;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private TextInputMode() {}
}
