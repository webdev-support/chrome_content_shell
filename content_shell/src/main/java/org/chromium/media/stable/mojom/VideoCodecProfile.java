package org.chromium.media.stable.mojom;

public final class VideoCodecProfile {
  public static final int AV1_PROFILE_HIGH = 25;
  public static final int AV1_PROFILE_MAIN = 24;
  public static final int AV1_PROFILE_MAX = 26;
  public static final int AV1_PROFILE_MIN = 24;
  public static final int AV1_PROFILE_PRO = 26;
  public static final int DEFAULT_VALUE = -1;
  public static final int DEPRECATED_DOLBY_VISION_PROFILE4 = 20;
  public static final int DOLBY_VISION_PROFILE0 = 19;
  public static final int DOLBY_VISION_PROFILE5 = 21;
  public static final int DOLBY_VISION_PROFILE7 = 22;
  public static final int DOLBY_VISION_PROFILE8 = 27;
  public static final int DOLBY_VISION_PROFILE9 = 28;
  public static final int H264_PROFILE_BASELINE = 0;
  public static final int H264_PROFILE_EXTENDED = 2;
  public static final int H264_PROFILE_HIGH = 3;
  public static final int H264_PROFILE_HIGH10 = 4;
  public static final int H264_PROFILE_HIGH422 = 5;
  public static final int H264_PROFILE_HIGH444_PREDICTIVE = 6;
  public static final int H264_PROFILE_MAIN = 1;
  public static final int H264_PROFILE_MAX = 10;
  public static final int H264_PROFILE_MIN = 0;
  public static final int H264_PROFILE_MULTIVIEW_HIGH = 10;
  public static final int H264_PROFILE_SCALABLE_BASELINE = 7;
  public static final int H264_PROFILE_SCALABLE_HIGH = 8;
  public static final int H264_PROFILE_STEREO_HIGH = 9;
  public static final int HEVC_PROFILE3D_MAIN = 33;
  public static final int HEVC_PROFILE_EXT_MAX = 36;
  public static final int HEVC_PROFILE_EXT_MIN = 29;
  public static final int HEVC_PROFILE_HIGH_THROUGHPUT = 30;
  public static final int HEVC_PROFILE_HIGH_THROUGHPUT_SCREEN_EXTENDED = 36;
  public static final int HEVC_PROFILE_MAIN = 16;
  public static final int HEVC_PROFILE_MAIN10 = 17;
  public static final int HEVC_PROFILE_MAIN_STILL_PICTURE = 18;
  public static final int HEVC_PROFILE_MAX = 18;
  public static final int HEVC_PROFILE_MIN = 16;
  public static final int HEVC_PROFILE_MULTIVIEW_MAIN = 31;
  public static final int HEVC_PROFILE_REXT = 29;
  public static final int HEVC_PROFILE_SCALABLE_MAIN = 32;
  public static final int HEVC_PROFILE_SCALABLE_REXT = 35;
  public static final int HEVC_PROFILE_SCREEN_EXTENDED = 34;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 51;
  public static final int MIN_VALUE = -1;
  public static final int THEORA_PROFILE_ANY = 23;
  public static final int THEORA_PROFILE_MAX = 23;
  public static final int THEORA_PROFILE_MIN = 23;
  public static final int VIDEO_CODEC_PROFILE_UNKNOWN = -1;
  public static final int VP8_PROFILE_ANY = 11;
  public static final int VP8_PROFILE_MAX = 11;
  public static final int VP8_PROFILE_MIN = 11;
  public static final int VP9_PROFILE0 = 12;
  public static final int VP9_PROFILE1 = 13;
  public static final int VP9_PROFILE2 = 14;
  public static final int VP9_PROFILE3 = 15;
  public static final int VP9_PROFILE_MAX = 15;
  public static final int VP9_PROFILE_MIN = 12;
  public static final int VVC_PROFILE_MAIN10 = 37;
  public static final int VVC_PROFILE_MAIN10444 = 41;
  public static final int VVC_PROFILE_MAIN10444_STILL = 49;
  public static final int VVC_PROFILE_MAIN10_STILL = 47;
  public static final int VVC_PROFILE_MAIN12 = 38;
  public static final int VVC_PROFILE_MAIN12444 = 42;
  public static final int VVC_PROFILE_MAIN12444_INTRA = 44;
  public static final int VVC_PROFILE_MAIN12444_STILL = 50;
  public static final int VVC_PROFILE_MAIN12_INTRA = 39;
  public static final int VVC_PROFILE_MAIN12_STILL = 48;
  public static final int VVC_PROFILE_MAIN16444 = 43;
  public static final int VVC_PROFILE_MAIN16444_INTRA = 45;
  public static final int VVC_PROFILE_MAIN16444_STILL = 51;
  public static final int VVC_PROFILE_MIN = 37;
  public static final int VVC_PROFILE_MULTILAYER_MAIN10 = 40;
  public static final int VVC_PROFILE_MULTILAYER_MAIN10444 = 46;
  public static final int VVC_PROILE_MAX = 51;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= -1 && value <= 51;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return -1;
  }

  private VideoCodecProfile() {}
}
