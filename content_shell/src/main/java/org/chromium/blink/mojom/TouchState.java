package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class TouchState {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int STATE_CANCELLED = 5;
  public static final int STATE_MAX = 5;
  public static final int STATE_MOVED = 3;
  public static final int STATE_PRESSED = 2;
  public static final int STATE_RELEASED = 1;
  public static final int STATE_STATIONARY = 4;
  public static final int STATE_UNDEFINED = 0;

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

  private TouchState() {}
}
