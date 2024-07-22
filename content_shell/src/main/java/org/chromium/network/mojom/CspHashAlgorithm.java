package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CspHashAlgorithm {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int SHA256 = 1;
  public static final int SHA384 = 2;
  public static final int SHA512 = 4;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    switch (value) {
      case 0:
      case 1:
      case 2:
      case 4:
        return true;
      case 3:
      default:
        return false;
    }
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private CspHashAlgorithm() {}
}
