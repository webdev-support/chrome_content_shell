package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ChannelFormat {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int K10 = 1;
  public static final int K16 = 2;
  public static final int K16_F = 3;

  public static final int f778K8 = 0;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;

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

  private ChannelFormat() {}
}
