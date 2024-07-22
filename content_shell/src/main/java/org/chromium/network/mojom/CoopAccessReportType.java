package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CoopAccessReportType {
  public static final int ACCESS_FROM_COOP_PAGE_TO_OPENEE = 1;
  public static final int ACCESS_FROM_COOP_PAGE_TO_OPENER = 0;
  public static final int ACCESS_FROM_COOP_PAGE_TO_OTHER = 2;
  public static final int ACCESS_TO_COOP_PAGE_FROM_OPENEE = 4;
  public static final int ACCESS_TO_COOP_PAGE_FROM_OPENER = 3;
  public static final int ACCESS_TO_COOP_PAGE_FROM_OTHER = 5;
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

  private CoopAccessReportType() {}
}
