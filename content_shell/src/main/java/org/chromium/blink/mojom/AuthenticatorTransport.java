package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class AuthenticatorTransport {
  public static final int BLE = 2;
  public static final int HYBRID = 3;
  public static final int INTERNAL = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int NFC = 1;
  public static final int USB = 0;

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

  private AuthenticatorTransport() {}
}
