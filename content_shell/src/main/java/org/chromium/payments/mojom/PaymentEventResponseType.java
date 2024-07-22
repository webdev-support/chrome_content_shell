package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class PaymentEventResponseType {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 20;
  public static final int MIN_VALUE = 0;
  public static final int PAYER_EMAIL_EMPTY = 1;
  public static final int PAYER_NAME_EMPTY = 0;
  public static final int PAYER_PHONE_EMPTY = 2;
  public static final int PAYMENT_DETAILS_ABSENT = 3;
  public static final int PAYMENT_DETAILS_NOT_OBJECT = 4;
  public static final int PAYMENT_DETAILS_STRINGIFY_ERROR = 5;
  public static final int PAYMENT_EVENT_BROWSER_ERROR = 6;
  public static final int PAYMENT_EVENT_INTERNAL_ERROR = 7;
  public static final int PAYMENT_EVENT_NO_RESPONSE = 8;
  public static final int PAYMENT_EVENT_REJECT = 9;
  public static final int PAYMENT_EVENT_SERVICE_WORKER_ERROR = 10;
  public static final int PAYMENT_EVENT_SUCCESS = 11;
  public static final int PAYMENT_EVENT_TIMEOUT = 12;
  public static final int PAYMENT_HANDLER_ACTIVITY_DIED = 13;
  public static final int PAYMENT_HANDLER_FAIL_TO_LOAD_MAIN_FRAME = 14;
  public static final int PAYMENT_HANDLER_INSECURE_NAVIGATION = 15;
  public static final int PAYMENT_HANDLER_INSTALL_FAILED = 16;
  public static final int PAYMENT_HANDLER_WINDOW_CLOSING = 17;
  public static final int PAYMENT_METHOD_NAME_EMPTY = 18;
  public static final int SHIPPING_ADDRESS_INVALID = 19;
  public static final int SHIPPING_OPTION_EMPTY = 20;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 20;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private PaymentEventResponseType() {}
}
