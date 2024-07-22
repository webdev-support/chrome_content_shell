package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class SelectionBoundType {
  public static final int CENTER = 2;
  public static final int EMPTY = 4;
  public static final int HIDDEN = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LAST = 4;
  public static final int LEFT = 0;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int RIGHT = 1;

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

  private SelectionBoundType() {}
}
