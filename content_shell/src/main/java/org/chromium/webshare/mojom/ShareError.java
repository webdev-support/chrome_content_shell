package org.chromium.webshare.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ShareError {
  public static final int CANCELED = 3;
  public static final int INTERNAL_ERROR = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;

  public static final int f791OK = 0;
  public static final int PERMISSION_DENIED = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 3;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private ShareError() {}
}
