package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class LinkRelAttribute {
  public static final int DNS_PREFETCH = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int MODULE_PRELOAD = 3;
  public static final int PRECONNECT = 1;
  public static final int PRELOAD = 2;

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

  private LinkRelAttribute() {}
}
