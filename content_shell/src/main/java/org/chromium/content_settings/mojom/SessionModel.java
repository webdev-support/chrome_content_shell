package org.chromium.content_settings.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class SessionModel {
  public static final int DURABLE = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int NON_RESTORABLE_USER_SESSION = 2;
  public static final int ONE_TIME = 3;
  public static final int USER_SESSION = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 3;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private SessionModel() {}
}
