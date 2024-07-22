package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ModelStreamingResponseStatus {
  public static final int COMPLETE = 1;
  public static final int ERROR_CANCELLED = 12;
  public static final int ERROR_DISABLED = 11;
  public static final int ERROR_FILTERED = 10;
  public static final int ERROR_GENERIC_FAILURE = 6;
  public static final int ERROR_INVALID_REQUEST = 3;
  public static final int ERROR_NON_RETRYABLE_ERROR = 8;
  public static final int ERROR_PERMISSION_DENIED = 5;
  public static final int ERROR_REQUEST_THROTTLED = 4;
  public static final int ERROR_RETRYABLE_ERROR = 7;
  public static final int ERROR_UNKNOWN = 2;
  public static final int ERROR_UNSUPPORTED_LANGUAGE = 9;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 12;
  public static final int MIN_VALUE = 0;
  public static final int ONGOING = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 12;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private ModelStreamingResponseStatus() {}
}
