package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ContextType {
  public static final int CROSS_SITE = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int SAME_SITE_LAX = 2;
  public static final int SAME_SITE_LAX_METHOD_UNSAFE = 1;
  public static final int SAME_SITE_STRICT = 3;

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

  private ContextType() {}
}
