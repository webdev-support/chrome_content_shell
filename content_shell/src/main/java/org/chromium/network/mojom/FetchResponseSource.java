package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class FetchResponseSource {
  public static final int CACHE_STORAGE = 3;
  public static final int HTTP_CACHE = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int NETWORK = 1;
  public static final int UNSPECIFIED = 0;

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

  private FetchResponseSource() {}
}
