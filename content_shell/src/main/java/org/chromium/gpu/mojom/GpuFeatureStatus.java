package org.chromium.gpu.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class GpuFeatureStatus {
  public static final int BLOCKLISTED = 1;
  public static final int DISABLED = 2;
  public static final int ENABLED = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX = 5;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int SOFTWARE = 3;
  public static final int UNDEFINED = 4;

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

  private GpuFeatureStatus() {}
}
