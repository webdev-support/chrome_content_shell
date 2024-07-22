package org.chromium.ax.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class DefaultActionVerb {
  public static final int ACTIVATE = 1;
  public static final int CHECK = 2;
  public static final int CLICK = 3;
  public static final int CLICK_ANCESTOR = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int JUMP = 5;
  public static final int MAX_VALUE = 9;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int OPEN = 6;
  public static final int PRESS = 7;
  public static final int SELECT = 8;
  public static final int UNCHECK = 9;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 9;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private DefaultActionVerb() {}
}
