package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class V8CacheOptions {
  public static final int CODE = 2;
  public static final int CODE_WITHOUT_HEAT_CHECK = 3;
  public static final int DEFAULT = 0;
  public static final int FULL_CODE_WITHOUT_HEAT_CHECK = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 1;

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

  private V8CacheOptions() {}
}
