package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CookieExclusionReason {
  public static final int EXCLUDE_DOMAIN_NON_ASCII = 4;
  public static final int EXCLUDE_SAME_SITE_LAX = 2;
  public static final int EXCLUDE_SAME_SITE_NONE_INSECURE = 1;
  public static final int EXCLUDE_SAME_SITE_STRICT = 3;
  public static final int EXCLUDE_SAME_SITE_UNSPECIFIED_TREATED_AS_LAX = 0;
  public static final int EXCLUDE_THIRD_PARTY_PHASEOUT = 5;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 5;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private CookieExclusionReason() {}
}
