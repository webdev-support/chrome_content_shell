package org.chromium.media_session.mojom;

public final class MediaSessionAction {
  public static final int ENTER_AUTO_PICTURE_IN_PICTURE = 20;
  public static final int ENTER_PICTURE_IN_PICTURE = 10;
  public static final int EXIT_PICTURE_IN_PICTURE = 11;
  public static final int HANG_UP = 15;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 20;
  public static final int MIN_VALUE = 0;
  public static final int NEXT_SLIDE = 19;
  public static final int NEXT_TRACK = 3;
  public static final int PAUSE = 1;
  public static final int PLAY = 0;
  public static final int PREVIOUS_SLIDE = 18;
  public static final int PREVIOUS_TRACK = 2;
  public static final int RAISE = 16;
  public static final int SCRUB_TO = 9;
  public static final int SEEK_BACKWARD = 4;
  public static final int SEEK_FORWARD = 5;
  public static final int SEEK_TO = 8;
  public static final int SET_MUTE = 17;
  public static final int SKIP_AD = 6;
  public static final int STOP = 7;
  public static final int SWITCH_AUDIO_DEVICE = 12;
  public static final int TOGGLE_CAMERA = 14;
  public static final int TOGGLE_MICROPHONE = 13;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 20;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    return value;
  }

  private MediaSessionAction() {}
}
