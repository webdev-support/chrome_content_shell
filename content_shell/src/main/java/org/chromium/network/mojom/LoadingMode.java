package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class LoadingMode {
  public static final int CREDENTIALED_PRERENDER = 3;
  public static final int DEFAULT = 0;
  public static final int FENCED_FRAME = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int UNCREDENTIALED_PREFETCH = 1;
  public static final int UNCREDENTIALED_PRERENDER = 2;

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

  private LoadingMode() {}
}
