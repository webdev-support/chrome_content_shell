package org.chromium.blink.test.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class Ctap2Version {
  public static final int CTAP2_0 = 0;
  public static final int CTAP2_1 = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 1;
  public static final int MIN_VALUE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 1;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private Ctap2Version() {}
}