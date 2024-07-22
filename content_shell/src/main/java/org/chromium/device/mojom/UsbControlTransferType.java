package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class UsbControlTransferType {
  public static final int CLASS = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int RESERVED = 3;
  public static final int STANDARD = 0;
  public static final int VENDOR = 2;

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

  private UsbControlTransferType() {}
}
