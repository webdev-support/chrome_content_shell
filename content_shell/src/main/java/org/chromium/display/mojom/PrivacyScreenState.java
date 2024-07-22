package org.chromium.display.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class PrivacyScreenState {
  public static final int DISABLED = 0;
  public static final int DISABLED_LOCKED = 2;
  public static final int ENABLED = 1;
  public static final int ENABLED_LOCKED = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int NOT_SUPPORTED = 4;

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

  private PrivacyScreenState() {}
}
