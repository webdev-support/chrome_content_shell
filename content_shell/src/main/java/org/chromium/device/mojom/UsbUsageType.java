package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class UsbUsageType {
  public static final int DATA = 0;
  public static final int EXPLICIT_FEEDBACK = 2;
  public static final int FEEDBACK = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int NOTIFICATION = 4;
  public static final int PERIODIC = 3;
  public static final int RESERVED = 5;

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

  private UsbUsageType() {}
}
