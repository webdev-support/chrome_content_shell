package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class PointerType {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 1;
  public static final int POINTER_COARSE_TYPE = 2;
  public static final int POINTER_FINE_TYPE = 4;
  public static final int POINTER_FIRST_TYPE = 1;
  public static final int POINTER_NONE = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    switch (value) {
      case 1:
      case 2:
      case 4:
        return true;
      case 3:
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

  private PointerType() {}
}
