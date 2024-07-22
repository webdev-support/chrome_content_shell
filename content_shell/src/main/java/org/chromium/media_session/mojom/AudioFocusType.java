package org.chromium.media_session.mojom;

public final class AudioFocusType {
  public static final int AMBIENT = 3;
  public static final int GAIN = 0;
  public static final int GAIN_TRANSIENT = 2;
  public static final int GAIN_TRANSIENT_MAY_DUCK = 1;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 3;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    return value;
  }

  private AudioFocusType() {}
}
