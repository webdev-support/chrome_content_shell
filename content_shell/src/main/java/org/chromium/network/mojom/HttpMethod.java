package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class HttpMethod {
  public static final int CONNECT = 7;
  public static final int DELETE = 6;
  public static final int GET = 2;
  public static final int HEAD = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 10;
  public static final int MIN_VALUE = 0;
  public static final int OPTIONS = 8;
  public static final int PATCH = 10;
  public static final int POST = 4;
  public static final int PUT = 5;
  public static final int TRACE = 9;
  public static final int UNKNOWN = 1;
  public static final int UNSET = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 10;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private HttpMethod() {}
}
