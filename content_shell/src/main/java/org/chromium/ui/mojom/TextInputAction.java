package org.chromium.ui.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class TextInputAction {
  public static final int DEFAULT = 0;
  public static final int DONE = 2;
  public static final int ENTER = 1;
  public static final int GO = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 7;
  public static final int MIN_VALUE = 0;
  public static final int NEXT = 4;
  public static final int PREVIOUS = 5;
  public static final int SEARCH = 6;
  public static final int SEND = 7;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 7;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private TextInputAction() {}
}
