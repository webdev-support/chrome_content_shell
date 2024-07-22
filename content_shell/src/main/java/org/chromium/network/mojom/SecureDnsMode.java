package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class SecureDnsMode {
  public static final int AUTOMATIC = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;
  public static final int OFF = 0;
  public static final int SECURE = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 2;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private SecureDnsMode() {}
}
