package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class FetchResponseType {
  public static final int BASIC = 0;
  public static final int CORS = 1;
  public static final int DEFAULT = 2;
  public static final int ERROR = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int OPAQUE = 4;
  public static final int OPAQUE_REDIRECT = 5;

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

  private FetchResponseType() {}
}
