package org.chromium.media.stable.mojom;

public final class VideoDecoderType {
  public static final int DEFAULT_VALUE = 0;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int TESTING = 4;
  public static final int UNKNOWN = 0;
  public static final int V4L2 = 3;
  public static final int VAAPI = 1;
  public static final int VDA = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 4;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private VideoDecoderType() {}
}
