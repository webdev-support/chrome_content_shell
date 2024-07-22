package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class UsbControlTransferRecipient {
  public static final int DEVICE = 0;
  public static final int ENDPOINT = 2;
  public static final int INTERFACE = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int OTHER = 3;

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

  private UsbControlTransferRecipient() {}
}
