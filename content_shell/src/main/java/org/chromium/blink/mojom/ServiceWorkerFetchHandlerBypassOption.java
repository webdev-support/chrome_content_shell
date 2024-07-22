package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ServiceWorkerFetchHandlerBypassOption {
  public static final int AUTO_PRELOAD = 4;
  public static final int BYPASS_ONLY_IF_SERVICE_WORKER_NOT_STARTED = 1;
  public static final int DEFAULT = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int RACE_NETWORK_REQUEST = 2;
  public static final int RACE_NETWORK_REQUEST_HOLDBACK = 3;

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

  private ServiceWorkerFetchHandlerBypassOption() {}
}
