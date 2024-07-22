package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class TriggeringEventInfo {
  public static final int FROM_TRUSTED_EVENT = 2;
  public static final int FROM_UNTRUSTED_EVENT = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int NOT_FROM_EVENT = 1;
  public static final int UNKNOWN = 0;

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

  private TriggeringEventInfo() {}
}
