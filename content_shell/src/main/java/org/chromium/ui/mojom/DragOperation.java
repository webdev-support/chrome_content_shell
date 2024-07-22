package org.chromium.ui.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class DragOperation {
  public static final int COPY = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LINK = 2;
  public static final int MAX_VALUE = 16;
  public static final int MIN_VALUE = 0;
  public static final int MOVE = 16;
  public static final int NONE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    switch (value) {
      case 0:
      case 1:
      case 2:
      case 16:
        return true;
      default:
        return false;
    }
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private DragOperation() {}
}
