package org.chromium.gpu.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class Direct3DFeatureLevel {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int K10_0 = 4;
  public static final int K10_1 = 5;
  public static final int K11_0 = 6;
  public static final int K11_1 = 7;
  public static final int K12_0 = 8;
  public static final int K12_1 = 9;
  public static final int K12_2 = 10;
  public static final int K1_0_CORE = 0;
  public static final int K9_1 = 1;
  public static final int K9_2 = 2;
  public static final int K9_3 = 3;
  public static final int MAX_VALUE = 10;
  public static final int MIN_VALUE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 10;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private Direct3DFeatureLevel() {}
}
