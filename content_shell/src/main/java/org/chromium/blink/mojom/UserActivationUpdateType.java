package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class UserActivationUpdateType {
  public static final int CLEAR_ACTIVATION = 3;
  public static final int CONSUME_TRANSIENT_ACTIVATION = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int NOTIFY_ACTIVATION = 0;
  public static final int NOTIFY_ACTIVATION_PENDING_BROWSER_VERIFICATION = 1;

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

  private UserActivationUpdateType() {}
}
