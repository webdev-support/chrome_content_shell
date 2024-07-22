package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CookieChangeCause {
  public static final int EVICTED = 5;
  public static final int EXPIRED = 4;
  public static final int EXPIRED_OVERWRITE = 6;
  public static final int EXPLICIT = 1;
  public static final int INSERTED = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 6;
  public static final int MIN_VALUE = 0;
  public static final int OVERWRITE = 3;
  public static final int UNKNOWN_DELETION = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 6;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private CookieChangeCause() {}
}
