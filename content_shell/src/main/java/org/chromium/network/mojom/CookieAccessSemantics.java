package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CookieAccessSemantics {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LEGACY = 1;
  public static final int MAX_VALUE = 1;
  public static final int MIN_VALUE = -1;
  public static final int NONLEGACY = 0;
  public static final int UNKNOWN = -1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= -1 && value <= 1;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private CookieAccessSemantics() {}
}
