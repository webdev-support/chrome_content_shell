package org.chromium.device.mojom;

public final class HidBusType {
  public static final int HID_BUS_TYPE_BLUETOOTH = 1;
  public static final int HID_BUS_TYPE_UNKNOWN = 2;
  public static final int HID_BUS_TYPE_USB = 0;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 2;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    return value;
  }

  private HidBusType() {}
}
