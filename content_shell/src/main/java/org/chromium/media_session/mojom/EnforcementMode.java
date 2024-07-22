package org.chromium.media_session.mojom;

public final class EnforcementMode {
  public static final int DEFAULT = 0;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 1;
  public static final int SINGLE_GROUP = 2;
  public static final int SINGLE_SESSION = 3;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 3;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    return value;
  }

  private EnforcementMode() {}
}
