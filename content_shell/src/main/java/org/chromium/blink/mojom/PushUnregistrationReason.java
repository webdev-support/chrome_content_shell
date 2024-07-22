package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class PushUnregistrationReason {
  public static final int DELIVERY_NO_SERVICE_WORKER = 5;
  public static final int DELIVERY_PERMISSION_DENIED = 4;
  public static final int DELIVERY_UNKNOWN_APP_ID = 3;
  public static final int GCM_STORE_RESET = 6;
  public static final int GET_SUBSCRIPTION_STORAGE_CORRUPT = 9;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int JAVASCRIPT_API = 1;
  public static final int MAX_VALUE = 15;
  public static final int MIN_VALUE = 0;
  public static final int NO_APP_LEVEL_PERMISSION = 14;
  public static final int PERMISSION_REVOKED = 2;
  public static final int PERMISSION_REVOKED_ABUSIVE = 13;
  public static final int PERMISSION_REVOKED_DISRUPTIVE = 15;
  public static final int REFRESH_FINISHED = 12;
  public static final int SERVICE_WORKER_DATABASE_WIPED = 10;
  public static final int SERVICE_WORKER_UNREGISTERED = 7;
  public static final int SUBSCRIBE_STORAGE_CORRUPT = 8;
  public static final int SUBSCRIPTION_EXPIRED = 11;
  public static final int UNKNOWN = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 15;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private PushUnregistrationReason() {}
}
