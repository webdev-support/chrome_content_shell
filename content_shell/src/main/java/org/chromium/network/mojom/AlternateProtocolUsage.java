package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class AlternateProtocolUsage {
  public static final int BROKEN = 4;
  public static final int DNS_ALPN_H3_JOB_WON_RACE = 6;
  public static final int DNS_ALPN_H3_JOB_WON_WITHOUT_RACE = 5;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAIN_JOB_WON_RACE = 2;
  public static final int MAPPING_MISSING = 3;
  public static final int MAX_VALUE = 7;
  public static final int MIN_VALUE = 0;
  public static final int NO_RACE = 0;
  public static final int UNSPECIFIED_REASON = 7;
  public static final int WON_RACE = 1;

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

  private AlternateProtocolUsage() {}
}
