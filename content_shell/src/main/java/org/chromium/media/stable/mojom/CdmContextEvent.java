package org.chromium.media.stable.mojom;

public final class CdmContextEvent {
  public static final int DEFAULT_VALUE = 0;
  public static final int HARDWARE_CONTEXT_RESET = 1;
  public static final int HAS_ADDITIONAL_USABLE_KEY = 0;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 1;
  public static final int MIN_VALUE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 1;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private CdmContextEvent() {}
}
