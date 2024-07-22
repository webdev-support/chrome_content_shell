package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class PointerLockResult {
  public static final int ALREADY_LOCKED = 5;
  public static final int ELEMENT_DESTROYED = 7;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 8;
  public static final int MIN_VALUE = 0;
  public static final int PERMISSION_DENIED = 4;
  public static final int REQUIRES_USER_GESTURE = 2;
  public static final int SUCCESS = 0;
  public static final int UNKNOWN_ERROR = 8;
  public static final int UNSUPPORTED_OPTIONS = 1;
  public static final int USER_REJECTED = 3;
  public static final int WRONG_DOCUMENT = 6;

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

  private PointerLockResult() {}
}
