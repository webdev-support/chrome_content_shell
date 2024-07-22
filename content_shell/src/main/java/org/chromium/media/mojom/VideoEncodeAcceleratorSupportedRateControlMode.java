package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class VideoEncodeAcceleratorSupportedRateControlMode {
  public static final int CONSTANT_MODE = 1;
  public static final int EXTERNAL_MODE = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int NO_MODE = 0;
  public static final int VARIABLE_MODE = 2;

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

  private VideoEncodeAcceleratorSupportedRateControlMode() {}
}
