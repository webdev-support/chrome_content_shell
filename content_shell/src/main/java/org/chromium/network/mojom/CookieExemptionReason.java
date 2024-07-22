package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CookieExemptionReason {
  public static final int CORS_OPT_IN = 8;
  public static final int ENTERPRISE_POLICY = 5;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int K3_PCD_DEPRECATION_TRIAL = 3;
  public static final int K3_PCD_HEURISTICS = 4;
  public static final int K3_PCD_METADATA = 2;
  public static final int MAX_VALUE = 8;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int STORAGE_ACCESS = 6;
  public static final int TOP_LEVEL_STORAGE_ACCESS = 7;
  public static final int USER_SETTING = 1;

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

  private CookieExemptionReason() {}
}
