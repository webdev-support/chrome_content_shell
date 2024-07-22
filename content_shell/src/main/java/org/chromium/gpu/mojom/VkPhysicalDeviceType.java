package org.chromium.gpu.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class VkPhysicalDeviceType {
  public static final int CPU = 4;
  public static final int DISCRETE_GPU = 2;
  public static final int INTEGRATED_GPU = 1;
  public static final int INVALID_VALUE = -1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = -1;
  public static final int OTHER = 0;
  public static final int VIRTUAL_GPU = 3;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= -1 && value <= 4;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private VkPhysicalDeviceType() {}
}
