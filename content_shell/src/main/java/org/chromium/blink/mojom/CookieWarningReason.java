package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CookieWarningReason {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 11;
  public static final int MIN_VALUE = 0;
  public static final int WARN_ATTRIBUTE_VALUE_EXCEEDS_MAX_SIZE = 8;
  public static final int WARN_CROSS_SITE_REDIRECT_DOWNGRADE_CHANGES_INCLUSION = 11;
  public static final int WARN_DOMAIN_NON_ASCII = 9;
  public static final int WARN_SAME_SITE_LAX_CROSS_DOWNGRADE_LAX = 7;
  public static final int WARN_SAME_SITE_LAX_CROSS_DOWNGRADE_STRICT = 6;
  public static final int WARN_SAME_SITE_NONE_INSECURE = 1;
  public static final int WARN_SAME_SITE_STRICT_CROSS_DOWNGRADE_LAX = 5;
  public static final int WARN_SAME_SITE_STRICT_CROSS_DOWNGRADE_STRICT = 4;
  public static final int WARN_SAME_SITE_STRICT_LAX_DOWNGRADE_STRICT = 3;
  public static final int WARN_SAME_SITE_UNSPECIFIED_CROSS_SITE_CONTEXT = 0;
  public static final int WARN_SAME_SITE_UNSPECIFIED_LAX_ALLOW_UNSAFE = 2;
  public static final int WARN_THIRD_PARTY_PHASEOUT = 10;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 11;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private CookieWarningReason() {}
}
