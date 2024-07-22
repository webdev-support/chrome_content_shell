package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class AttributionReportingEligibility {
  public static final int EMPTY = 1;
  public static final int EVENT_SOURCE = 2;
  public static final int EVENT_SOURCE_OR_TRIGGER = 5;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int NAVIGATION_SOURCE = 3;
  public static final int TRIGGER = 4;
  public static final int UNSET = 0;

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

  private AttributionReportingEligibility() {}
}
