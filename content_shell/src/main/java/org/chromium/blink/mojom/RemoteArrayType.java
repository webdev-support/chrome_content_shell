package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class RemoteArrayType {
  public static final int FLOAT32_ARRAY = 7;
  public static final int FLOAT64_ARRAY = 8;
  public static final int INT16_ARRAY = 3;
  public static final int INT32_ARRAY = 5;
  public static final int INT8_ARRAY = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 8;
  public static final int MIN_VALUE = 1;
  public static final int UINT16_ARRAY = 4;
  public static final int UINT32_ARRAY = 6;
  public static final int UINT8_ARRAY = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 1 && value <= 8;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private RemoteArrayType() {}
}
