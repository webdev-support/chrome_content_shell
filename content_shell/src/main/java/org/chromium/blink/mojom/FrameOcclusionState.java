package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class FrameOcclusionState {
  public static final int GUARANTEED_NOT_OCCLUDED = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;
  public static final int POSSIBLY_OCCLUDED = 1;
  public static final int UNKNOWN = 0;

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

  private FrameOcclusionState() {}
}
