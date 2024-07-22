package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class StylusWritingGestureAction {
  public static final int ADD_SPACE_OR_TEXT = 1;
  public static final int DELETE_TEXT = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int REMOVE_SPACES = 2;
  public static final int SELECT_TEXT = 4;
  public static final int SPLIT_OR_MERGE = 3;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 4;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private StylusWritingGestureAction() {}
}
