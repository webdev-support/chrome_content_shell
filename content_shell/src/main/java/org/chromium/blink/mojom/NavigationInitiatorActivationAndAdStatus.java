package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class NavigationInitiatorActivationAndAdStatus {
  public static final int DID_NOT_START_WITH_TRANSIENT_ACTIVATION = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;
  public static final int STARTED_WITH_TRANSIENT_ACTIVATION_FROM_AD = 2;
  public static final int STARTED_WITH_TRANSIENT_ACTIVATION_FROM_NON_AD = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 2;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private NavigationInitiatorActivationAndAdStatus() {}
}
