package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class SerialReceiveError {
  public static final int BREAK = 3;
  public static final int BUFFER_OVERFLOW = 6;
  public static final int DEVICE_LOST = 2;
  public static final int DISCONNECTED = 1;
  public static final int FRAME_ERROR = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 8;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int OVERRUN = 5;
  public static final int PARITY_ERROR = 7;
  public static final int SYSTEM_ERROR = 8;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 8;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private SerialReceiveError() {}
}
