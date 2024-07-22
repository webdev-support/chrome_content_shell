package org.chromium.gpu.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class GpuPeakMemoryAllocationSource {
  public static final int COMMAND_BUFFER = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int SHARED_CONTEXT_STATE = 2;
  public static final int SHARED_IMAGE_STUB = 3;
  public static final int SKIA = 4;
  public static final int UNKNOWN = 0;

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

  private GpuPeakMemoryAllocationSource() {}
}
