package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class SvcScalabilityMode {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int L1T1 = 1;
  public static final int L1T2 = 2;
  public static final int L1T3 = 3;
  public static final int L2T1 = 4;
  public static final int L2T1_KEY = 10;
  public static final int L2T2 = 5;
  public static final int L2T2_KEY = 11;
  public static final int L2T3 = 6;
  public static final int L2T3_KEY = 12;
  public static final int L3T1 = 7;
  public static final int L3T1_KEY = 13;
  public static final int L3T2 = 8;
  public static final int L3T2_KEY = 14;
  public static final int L3T3 = 9;
  public static final int L3T3_KEY = 15;
  public static final int MAX_VALUE = 21;
  public static final int MIN_VALUE = 0;
  public static final int S2T1 = 16;
  public static final int S2T2 = 17;
  public static final int S2T3 = 18;
  public static final int S3T1 = 19;
  public static final int S3T2 = 20;
  public static final int S3T3 = 21;
  public static final int UNSUPPORTED_MODE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 21;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private SvcScalabilityMode() {}
}
