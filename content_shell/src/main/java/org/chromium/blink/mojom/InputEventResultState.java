package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class InputEventResultState {
  public static final int CONSUMED = 1;
  public static final int IGNORED = 5;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 7;
  public static final int MIN_VALUE = 0;
  public static final int NOT_CONSUMED = 2;
  public static final int NOT_CONSUMED_BLOCKING = 3;
  public static final int NO_CONSUMER_EXISTS = 4;
  public static final int SET_NON_BLOCKING = 6;
  public static final int SET_NON_BLOCKING_DUE_TO_FLING = 7;
  public static final int UNKNOWN = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 7;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private InputEventResultState() {}
}
