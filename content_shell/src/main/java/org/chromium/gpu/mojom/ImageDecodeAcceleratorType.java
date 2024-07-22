package org.chromium.gpu.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ImageDecodeAcceleratorType {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int JPEG = 0;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;
  public static final int UNKNOWN = 2;
  public static final int WEB_P = 1;

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

  private ImageDecodeAcceleratorType() {}
}
