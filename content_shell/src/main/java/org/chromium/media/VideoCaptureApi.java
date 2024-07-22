package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface VideoCaptureApi {
  public static final int ANDROID_API1 = 7;
  public static final int ANDROID_API2_FULL = 9;
  public static final int ANDROID_API2_LEGACY = 8;
  public static final int ANDROID_API2_LIMITED = 10;
  public static final int FUCHSIA_CAMERA3 = 11;
  public static final int LINUX_V4L2_SINGLE_PLANE = 1;
  public static final int MACOSX_AVFOUNDATION = 5;
  public static final int MACOSX_DECKLINK = 6;
  public static final int MAX_VALUE = 12;
  public static final int UNKNOWN = 0;
  public static final int VIRTUAL_DEVICE = 12;
  public static final int WIN_DIRECT_SHOW = 4;
  public static final int WIN_MEDIA_FOUNDATION = 2;
  public static final int WIN_MEDIA_FOUNDATION_SENSOR = 3;
}
