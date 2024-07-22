package org.chromium.ui.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class EventMomentumPhase {
  public static final int BEGAN = 1;
  public static final int BLOCKED = 5;
  public static final int END = 4;
  public static final int INERTIAL_UPDATE = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MAY_BEGIN = 2;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;

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

  private EventMomentumPhase() {}
}
