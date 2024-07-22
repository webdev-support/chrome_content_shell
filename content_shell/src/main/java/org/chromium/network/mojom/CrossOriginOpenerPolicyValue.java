package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CrossOriginOpenerPolicyValue {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int RESTRICT_PROPERTIES = 4;
  public static final int RESTRICT_PROPERTIES_PLUS_COEP = 5;
  public static final int SAME_ORIGIN = 2;
  public static final int SAME_ORIGIN_ALLOW_POPUPS = 1;
  public static final int SAME_ORIGIN_PLUS_COEP = 3;
  public static final int UNSAFE_NONE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 5;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private CrossOriginOpenerPolicyValue() {}
}
