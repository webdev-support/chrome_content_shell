package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class BasicCardNetwork {
  public static final int AMEX = 0;
  public static final int DINERS = 1;
  public static final int DISCOVER = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int JCB = 3;
  public static final int MASTERCARD = 4;
  public static final int MAX_VALUE = 7;
  public static final int MIN_VALUE = 0;
  public static final int MIR = 5;
  public static final int UNIONPAY = 6;
  public static final int VISA = 7;

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

  private BasicCardNetwork() {}
}
