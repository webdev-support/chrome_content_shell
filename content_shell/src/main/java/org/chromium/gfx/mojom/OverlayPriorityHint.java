package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class OverlayPriorityHint {
  public static final int HARDWARE_PROTECTION = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LOW_LATENCY_CANVAS = 2;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int REGULAR = 1;
  public static final int VIDEO = 4;

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

  private OverlayPriorityHint() {}
}
