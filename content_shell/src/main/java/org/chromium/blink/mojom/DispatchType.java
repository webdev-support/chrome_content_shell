package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class DispatchType {
  public static final int BLOCKING = 0;
  public static final int EVENT_NON_BLOCKING = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LISTENERS_FORCED_NON_BLOCKING_DUE_TO_FLING = 3;
  public static final int LISTENERS_NON_BLOCKING_PASSIVE = 2;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 3;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private DispatchType() {}
}
