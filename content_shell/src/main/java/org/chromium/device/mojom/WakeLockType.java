package org.chromium.device.mojom;

public final class WakeLockType {
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;
  public static final int PREVENT_APP_SUSPENSION = 0;
  public static final int PREVENT_DISPLAY_SLEEP = 1;
  public static final int PREVENT_DISPLAY_SLEEP_ALLOW_DIMMING = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 2;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    return value;
  }

  private WakeLockType() {}
}
