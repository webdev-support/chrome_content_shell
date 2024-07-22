package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class NoVarySearchParseError {
  public static final int DEFAULT_VALUE = 1;
  public static final int EXCEPT_NOT_STRING_LIST = 6;
  public static final int EXCEPT_WITHOUT_TRUE_PARAMS = 7;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 7;
  public static final int MIN_VALUE = 0;
  public static final int NON_BOOLEAN_KEY_ORDER = 4;
  public static final int NOT_DICTIONARY = 2;

  public static final int f702OK = 0;
  public static final int PARAMS_NOT_STRING_LIST = 5;
  public static final int UNKNOWN_DICTIONARY_KEY = 3;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 7;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private NoVarySearchParseError() {}
}
