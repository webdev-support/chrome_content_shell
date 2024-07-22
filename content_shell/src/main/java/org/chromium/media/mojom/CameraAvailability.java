package org.chromium.media.mojom;

public final class CameraAvailability {
  public static final int AVAILABLE = 0;
  public static final int DEFAULT_VALUE = 0;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 1;
  public static final int MIN_VALUE = 0;
  public static final int UNAVAILABLE_EXCLUSIVELY_USED_BY_OTHER_APPLICATION = 1;

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

  private CameraAvailability() {}
}
