package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class PlaneConfig {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int Y_UV = 2;
  public static final int Y_UV_A = 3;
  public static final int Y_U_V = 0;
  public static final int Y_U_V_A = 4;
  public static final int Y_V_U = 1;

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

  private PlaneConfig() {}
}
