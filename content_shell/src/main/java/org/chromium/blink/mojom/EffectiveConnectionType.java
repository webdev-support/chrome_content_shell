package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class EffectiveConnectionType {
  public static final int EFFECTIVE_CONNECTION2_G_TYPE = 3;
  public static final int EFFECTIVE_CONNECTION3_G_TYPE = 4;
  public static final int EFFECTIVE_CONNECTION4_G_TYPE = 5;
  public static final int EFFECTIVE_CONNECTION_OFFLINE_TYPE = 1;
  public static final int EFFECTIVE_CONNECTION_SLOW2_G_TYPE = 2;
  public static final int EFFECTIVE_CONNECTION_TYPE_LAST = 6;
  public static final int EFFECTIVE_CONNECTION_UNKNOWN_TYPE = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 6;
  public static final int MIN_VALUE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 6;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private EffectiveConnectionType() {}
}
