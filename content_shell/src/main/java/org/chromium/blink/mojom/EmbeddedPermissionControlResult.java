package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class EmbeddedPermissionControlResult {
  public static final int DENIED = 2;
  public static final int DISMISSED = 0;
  public static final int GRANTED = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int NOT_SUPPORTED = 3;
  public static final int RESOLVED_NO_USER_GESTURE = 4;

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

  private EmbeddedPermissionControlResult() {}
}
