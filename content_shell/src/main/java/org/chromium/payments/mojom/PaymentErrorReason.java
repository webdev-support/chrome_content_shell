package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class PaymentErrorReason {
  public static final int ALREADY_SHOWING = 4;
  public static final int INVALID_DATA_FROM_RENDERER = 5;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 8;
  public static final int MIN_VALUE = 0;
  public static final int NOT_ALLOWED_ERROR = 6;
  public static final int NOT_SUPPORTED = 2;
  public static final int NOT_SUPPORTED_FOR_INVALID_ORIGIN_OR_SSL = 3;
  public static final int UNKNOWN = 0;
  public static final int USER_ACTIVATION_REQUIRED = 8;
  public static final int USER_CANCEL = 1;
  public static final int USER_OPT_OUT = 7;

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

  private PaymentErrorReason() {}
}
