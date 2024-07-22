package org.chromium.media.mojom;

public final class VideoCaptureApi {
  public static final int ANDROID_API1 = 6;
  public static final int ANDROID_API2_FULL = 8;
  public static final int ANDROID_API2_LEGACY = 7;
  public static final int ANDROID_API2_LIMITED = 9;
  public static final int FUCHSIA_CAMERA3 = 10;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int LINUX_V4L2_SINGLE_PLANE = 0;
  public static final int MACOSX_AVFOUNDATION = 4;
  public static final int MACOSX_DECKLINK = 5;
  public static final int MAX_VALUE = 12;
  public static final int MIN_VALUE = 0;
  public static final int UNKNOWN = 12;
  public static final int VIRTUAL_DEVICE = 11;
  public static final int WIN_DIRECT_SHOW = 3;
  public static final int WIN_MEDIA_FOUNDATION = 1;
  public static final int WIN_MEDIA_FOUNDATION_SENSOR = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 12;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    return value;
  }

  private VideoCaptureApi() {}
}
