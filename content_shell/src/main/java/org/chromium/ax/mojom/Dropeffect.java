package org.chromium.ax.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class Dropeffect {
  public static final int COPY = 1;
  public static final int EXECUTE = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LINK = 3;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int MOVE = 4;
  public static final int NONE = 0;
  public static final int POPUP = 5;

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

  private Dropeffect() {}
}
