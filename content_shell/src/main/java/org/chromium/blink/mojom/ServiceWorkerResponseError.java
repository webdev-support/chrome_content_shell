package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ServiceWorkerResponseError {
  public static final int BODY_LOCKED = 10;
  public static final int BODY_USED = 7;
  public static final int DATA_PIPE_CREATION_FAILED = 12;
  public static final int DEFAULT_PREVENTED = 2;
  public static final int DISALLOWED_BY_CORP = 15;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 16;
  public static final int MIN_VALUE = 0;
  public static final int NO_V8_INSTANCE = 3;
  public static final int PROMISE_REJECTED = 1;
  public static final int REDIRECTED_RESPONSE_FOR_NOT_FOLLOW_REQUEST = 11;
  public static final int REQUEST_BODY_UNUSABLE = 16;
  public static final int RESPONSE_BODY_BROKEN = 14;
  public static final int RESPONSE_TYPE_CORS_FOR_REQUEST_MODE_SAME_ORIGIN = 13;
  public static final int RESPONSE_TYPE_ERROR = 4;
  public static final int RESPONSE_TYPE_NOT_BASIC_OR_DEFAULT = 6;
  public static final int RESPONSE_TYPE_OPAQUE = 5;
  public static final int RESPONSE_TYPE_OPAQUE_FOR_CLIENT_REQUEST = 8;
  public static final int RESPONSE_TYPE_OPAQUE_REDIRECT = 9;
  public static final int UNKNOWN = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 16;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private ServiceWorkerResponseError() {}
}
