package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class PrivateNetworkRequestPolicy {
  public static final int ALLOW = 0;
  public static final int BLOCK = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int PREFLIGHT_BLOCK = 4;
  public static final int PREFLIGHT_WARN = 3;
  public static final int WARN = 1;

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

  private PrivateNetworkRequestPolicy() {}
}
