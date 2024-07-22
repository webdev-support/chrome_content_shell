package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class RuntimeFeature {
  public static final int BLINK_EXTENSION_CHROME_OS = 0;
  public static final int BLINK_EXTENSION_CHROME_OS_KIOSK = 1;
  public static final int BLINK_EXTENSION_DIAGNOSTICS = 2;
  public static final int DISABLE_THIRD_PARTY_STORAGE_PARTITIONING = 3;
  public static final int FED_CM_IDP_SIGNIN_STATUS = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 6;
  public static final int MIN_VALUE = 0;
  public static final int ORIGIN_TRIALS_SAMPLE_API_BROWSER_READ_WRITE = 5;
  public static final int TEST_FEATURE = 6;

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

  private RuntimeFeature() {}
}
