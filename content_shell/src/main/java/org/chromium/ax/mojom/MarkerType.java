package org.chromium.ax.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class MarkerType {
  public static final int ACTIVE_SUGGESTION = 16;
  public static final int GRAMMAR = 2;
  public static final int HIGHLIGHT = 64;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 64;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int SPELLING = 1;
  public static final int SUGGESTION = 32;
  public static final int TEXT_MATCH = 4;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    switch (value) {
      case 0:
      case 1:
      case 2:
      case 4:
      case 16:
      case 32:
      case 64:
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

  private MarkerType() {}
}
