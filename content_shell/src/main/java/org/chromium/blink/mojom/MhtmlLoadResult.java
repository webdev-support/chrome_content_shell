package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class MhtmlLoadResult {
  public static final int EMPTY_FILE = 1;
  public static final int INVALID_ARCHIVE = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int MISSING_MAIN_RESOURCE = 4;
  public static final int SUCCESS = 0;
  public static final int URL_SCHEME_NOT_ALLOWED = 2;

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

  private MhtmlLoadResult() {}
}
