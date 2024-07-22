package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class SmartCardConnectionState {
  public static final int ABSENT = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int NEGOTIABLE = 4;
  public static final int POWERED = 3;
  public static final int PRESENT = 1;
  public static final int SPECIFIC = 5;
  public static final int SWALLOWED = 2;

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

  private SmartCardConnectionState() {}
}
