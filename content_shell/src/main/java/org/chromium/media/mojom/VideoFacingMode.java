package org.chromium.media.mojom;

public final class VideoFacingMode {
  public static final int ENVIRONMENT = 2;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int USER = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 2;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    return value;
  }

  private VideoFacingMode() {}
}
