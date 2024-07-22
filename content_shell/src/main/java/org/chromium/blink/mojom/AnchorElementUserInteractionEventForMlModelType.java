package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class AnchorElementUserInteractionEventForMlModelType {
  public static final int ENTERED_VIEWPORT = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LEFT_VIEWPORT = 3;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int POINTER_OUT = 1;
  public static final int POINTER_OVER = 0;
  public static final int UNKNOWN = 4;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 4;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private AnchorElementUserInteractionEventForMlModelType() {}
}
