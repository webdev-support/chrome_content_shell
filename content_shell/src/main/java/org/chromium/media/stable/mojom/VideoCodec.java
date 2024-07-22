package org.chromium.media.stable.mojom;

public final class VideoCodec {
  public static final int AV1 = 10;
  public static final int DEFAULT_VALUE = 0;
  public static final int DOLBY_VISION = 9;
  public static final int H264 = 1;
  public static final int HEVC = 8;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 10;
  public static final int MIN_VALUE = 0;
  public static final int MPEG2 = 3;
  public static final int MPEG4 = 4;
  public static final int THEORA = 5;
  public static final int UNKNOWN = 0;
  public static final int VC1 = 2;
  public static final int VP8 = 6;
  public static final int VP9 = 7;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 10;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private VideoCodec() {}
}
