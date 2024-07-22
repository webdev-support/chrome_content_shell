package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class HasEnrolledInstrumentQueryResult {
  public static final int HAS_ENROLLED_INSTRUMENT = 0;
  public static final int HAS_NO_ENROLLED_INSTRUMENT = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int QUERY_QUOTA_EXCEEDED = 2;
  public static final int WARNING_HAS_ENROLLED_INSTRUMENT = 3;
  public static final int WARNING_HAS_NO_ENROLLED_INSTRUMENT = 4;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 4;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private HasEnrolledInstrumentQueryResult() {}
}
