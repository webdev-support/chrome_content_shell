package org.chromium.payments.mojom;

public final class BillingResponseCode {
  public static final int CLIENT_APP_ERROR = 6;
  public static final int CLIENT_APP_UNAVAILABLE = 5;
  public static final int DEFAULT_VALUE = 1;
  public static final int ERROR = 1;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int ITEM_ALREADY_OWNED = 2;
  public static final int ITEM_NOT_OWNED = 3;
  public static final int ITEM_UNAVAILABLE = 4;
  public static final int MAX_VALUE = 6;
  public static final int MIN_VALUE = 0;

  public static final int f710OK = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 6;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 1;
  }

  private BillingResponseCode() {}
}
