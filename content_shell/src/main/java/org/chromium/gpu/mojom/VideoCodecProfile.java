package org.chromium.gpu.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class VideoCodecProfile {
  public static final int AV1PROFILE_PROFILE_HIGH = 25;
  public static final int AV1PROFILE_PROFILE_MAIN = 24;
  public static final int AV1PROFILE_PROFILE_PRO = 26;
  public static final int DOLBYVISION_PROFILE0 = 19;
  public static final int DOLBYVISION_PROFILE5 = 21;
  public static final int DOLBYVISION_PROFILE7 = 22;
  public static final int DOLBYVISION_PROFILE8 = 27;
  public static final int DOLBYVISION_PROFILE9 = 28;
  public static final int H264PROFILE_BASELINE = 0;
  public static final int H264PROFILE_EXTENDED = 2;
  public static final int H264PROFILE_HIGH = 3;
  public static final int H264PROFILE_HIGH10PROFILE = 4;
  public static final int H264PROFILE_HIGH422PROFILE = 5;
  public static final int H264PROFILE_HIGH444PREDICTIVEPROFILE = 6;
  public static final int H264PROFILE_MAIN = 1;
  public static final int H264PROFILE_MULTIVIEWHIGH = 10;
  public static final int H264PROFILE_SCALABLEBASELINE = 7;
  public static final int H264PROFILE_SCALABLEHIGH = 8;
  public static final int H264PROFILE_STEREOHIGH = 9;
  public static final int HEVCPROFILE_3D_MAIN = 33;
  public static final int HEVCPROFILE_HIGH_THROUGHPUT = 30;
  public static final int HEVCPROFILE_HIGH_THROUGHPUT_SCREEN_EXTENDED = 36;
  public static final int HEVCPROFILE_MAIN = 16;
  public static final int HEVCPROFILE_MAIN10 = 17;
  public static final int HEVCPROFILE_MAIN_STILL_PICTURE = 18;
  public static final int HEVCPROFILE_MULTIVIEW_MAIN = 31;
  public static final int HEVCPROFILE_REXT = 29;
  public static final int HEVCPROFILE_SCALABLE_MAIN = 32;
  public static final int HEVCPROFILE_SCALABLE_REXT = 35;
  public static final int HEVCPROFILE_SCREEN_EXTENDED = 34;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 51;
  public static final int MIN_VALUE = -1;
  public static final int THEORAPROFILE_ANY = 23;
  public static final int VIDEO_CODEC_PROFILE_UNKNOWN = -1;
  public static final int VP8PROFILE_ANY = 11;
  public static final int VP9PROFILE_PROFILE0 = 12;
  public static final int VP9PROFILE_PROFILE1 = 13;
  public static final int VP9PROFILE_PROFILE2 = 14;
  public static final int VP9PROFILE_PROFILE3 = 15;
  public static final int VVCPROFILE_MAIN10 = 37;
  public static final int VVCPROFILE_MAIN10_444 = 41;
  public static final int VVCPROFILE_MAIN10_444_STILL_PICTURE = 49;
  public static final int VVCPROFILE_MAIN10_STILL_PICTURE = 47;
  public static final int VVCPROFILE_MAIN12 = 38;
  public static final int VVCPROFILE_MAIN12_444 = 42;
  public static final int VVCPROFILE_MAIN12_444_INTRA = 44;
  public static final int VVCPROFILE_MAIN12_444_STILL_PICTURE = 50;
  public static final int VVCPROFILE_MAIN12_INTRA = 39;
  public static final int VVCPROFILE_MAIN12_STILL_PICTURE = 48;
  public static final int VVCPROFILE_MAIN16_444 = 43;
  public static final int VVCPROFILE_MAIN16_444_INTRA = 45;
  public static final int VVCPROFILE_MAIN16_444_STILL_PICTURE = 51;
  public static final int VVCPROFILE_MULTILAYER_MAIN10_444 = 46;
  public static final int VVCPROIFLE_MULTILAYER_MAIN10 = 40;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    switch (value) {
      case -1:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
      case 21:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      case 33:
      case 34:
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:
      case 40:
      case 41:
      case 42:
      case 43:
      case 44:
      case 45:
      case 46:
      case 47:
      case 48:
      case 49:
      case 50:
      case 51:
        return true;
      case 20:
      default:
        return false;
    }
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private VideoCodecProfile() {}
}
