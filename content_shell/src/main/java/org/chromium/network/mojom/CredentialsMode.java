package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CredentialsMode {
  public static final int INCLUDE = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int OMIT = 0;
  public static final int OMIT_BUG_775438_WORKAROUND = 3;
  public static final int SAME_ORIGIN = 1;

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

  private CredentialsMode() {}
}