package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class FederatedAuthUserInfoRequestResult {
  public static final int INVALID_ACCOUNTS_RESPONSE = 8;
  public static final int INVALID_CONFIG_OR_WELL_KNOWN = 7;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 10;
  public static final int MIN_VALUE = 0;
  public static final int NOT_IFRAME = 2;
  public static final int NOT_POTENTIALLY_TRUSTWORTHY = 3;
  public static final int NOT_SAME_ORIGIN = 1;
  public static final int NOT_SIGNED_IN_WITH_IDP = 5;
  public static final int NO_ACCOUNT_SHARING_PERMISSION = 6;
  public static final int NO_API_PERMISSION = 4;
  public static final int NO_RETURNING_USER_FROM_FETCHED_ACCOUNTS = 9;
  public static final int SUCCESS = 0;
  public static final int UNHANDLED_REQUEST = 10;

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

  private FederatedAuthUserInfoRequestResult() {}
}
