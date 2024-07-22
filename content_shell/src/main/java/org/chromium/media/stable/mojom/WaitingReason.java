package org.chromium.media.stable.mojom;

public final class WaitingReason {
  public static final int DECODER_STATE_LOST = 2;
  public static final int DEFAULT_VALUE = 0;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int NO_CDM = 0;
  public static final int NO_DECRYPTION_KEY = 1;
  public static final int SECURE_SURFACE_LOST = 3;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 3;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private WaitingReason() {}
}
