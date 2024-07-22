package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class MediaStreamType {
  public static final int DEVICE_AUDIO_CAPTURE = 1;
  public static final int DEVICE_VIDEO_CAPTURE = 2;
  public static final int DISPLAY_AUDIO_CAPTURE = 8;
  public static final int DISPLAY_VIDEO_CAPTURE = 7;
  public static final int DISPLAY_VIDEO_CAPTURE_SET = 10;
  public static final int DISPLAY_VIDEO_CAPTURE_THIS_TAB = 9;
  public static final int GUM_DESKTOP_AUDIO_CAPTURE = 6;
  public static final int GUM_DESKTOP_VIDEO_CAPTURE = 5;
  public static final int GUM_TAB_AUDIO_CAPTURE = 3;
  public static final int GUM_TAB_VIDEO_CAPTURE = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 11;
  public static final int MIN_VALUE = 0;
  public static final int NO_SERVICE = 0;
  public static final int NUM_MEDIA_TYPES = 11;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 11;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private MediaStreamType() {}
}
