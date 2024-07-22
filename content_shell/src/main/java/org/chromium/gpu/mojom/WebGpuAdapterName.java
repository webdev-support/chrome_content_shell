package org.chromium.gpu.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class WebGpuAdapterName {
  public static final int D3D11 = 1;
  public static final int DEFAULT = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int OPEN_GLES = 2;
  public static final int SWIFT_SHADER = 3;

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

  private WebGpuAdapterName() {}
}
