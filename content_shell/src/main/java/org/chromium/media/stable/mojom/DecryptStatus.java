package org.chromium.media.stable.mojom;

public final class DecryptStatus {
  public static final int DEFAULT_VALUE = 2;
  public static final int FAILURE = 2;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;
  public static final int NO_KEY = 1;
  public static final int SUCCESS = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 2;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 2;
  }

  private DecryptStatus() {}
}
