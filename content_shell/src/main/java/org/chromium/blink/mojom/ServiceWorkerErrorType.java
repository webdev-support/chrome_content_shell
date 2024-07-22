package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ServiceWorkerErrorType {
  public static final int ABORT = 1;
  public static final int ACTIVATE = 2;
  public static final int DISABLED = 3;
  public static final int INSTALL = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 13;
  public static final int MIN_VALUE = 0;
  public static final int NAVIGATION = 5;
  public static final int NETWORK = 6;
  public static final int NONE = 0;
  public static final int NOT_FOUND = 7;
  public static final int SCRIPT_EVALUATE_FAILED = 8;
  public static final int SECURITY = 9;
  public static final int STATE = 10;
  public static final int TIMEOUT = 11;
  public static final int TYPE = 12;
  public static final int UNKNOWN = 13;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 13;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private ServiceWorkerErrorType() {}
}
