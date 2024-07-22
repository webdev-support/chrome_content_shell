package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class UsbTransferStatus {
  public static final int BABBLE = 6;
  public static final int CANCELLED = 3;
  public static final int COMPLETED = 0;
  public static final int DISCONNECT = 5;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 8;
  public static final int MIN_VALUE = 0;
  public static final int PERMISSION_DENIED = 8;
  public static final int SHORT_PACKET = 7;
  public static final int STALLED = 4;
  public static final int TIMEOUT = 2;
  public static final int TRANSFER_ERROR = 1;

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

  private UsbTransferStatus() {}
}
