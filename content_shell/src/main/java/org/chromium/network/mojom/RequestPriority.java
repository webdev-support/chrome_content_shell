package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class RequestPriority {
  public static final int HIGHEST = 5;
  public static final int IDLE = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LOW = 3;
  public static final int LOWEST = 2;
  public static final int MAX_VALUE = 5;
  public static final int MEDIUM = 4;
  public static final int MIN_VALUE = 0;
  public static final int THROTTLED = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 5;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private RequestPriority() {}
}
