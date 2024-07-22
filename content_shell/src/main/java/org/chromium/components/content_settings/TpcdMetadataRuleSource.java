package org.chromium.components.content_settings;

import org.chromium.mojo.bindings.DeserializationException;

public final class TpcdMetadataRuleSource {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 7;
  public static final int MIN_VALUE = 0;
  public static final int SOURCE_1P_DT = 2;
  public static final int SOURCE_3P_DT = 3;
  public static final int SOURCE_CRITICAL_SECTOR = 5;
  public static final int SOURCE_CUJ = 6;
  public static final int SOURCE_DOGFOOD = 4;
  public static final int SOURCE_GOV_EDU_TLD = 7;
  public static final int SOURCE_TEST = 1;
  public static final int SOURCE_UNSPECIFIED = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 7;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private TpcdMetadataRuleSource() {}
}
