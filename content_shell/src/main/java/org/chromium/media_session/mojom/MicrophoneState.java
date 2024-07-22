package org.chromium.media_session.mojom;

public final class MicrophoneState {
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;
  public static final int MUTED = 1;
  public static final int UNKNOWN = 0;
  public static final int UNMUTED = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 2;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    return value;
  }

  private MicrophoneState() {}
}
