package org.chromium.ax.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class Gesture {
  public static final int CLICK = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 21;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int SWIPE_DOWN1 = 5;
  public static final int SWIPE_DOWN2 = 9;
  public static final int SWIPE_DOWN3 = 13;
  public static final int SWIPE_DOWN4 = 17;
  public static final int SWIPE_LEFT1 = 2;
  public static final int SWIPE_LEFT2 = 6;
  public static final int SWIPE_LEFT3 = 10;
  public static final int SWIPE_LEFT4 = 14;
  public static final int SWIPE_RIGHT1 = 4;
  public static final int SWIPE_RIGHT2 = 8;
  public static final int SWIPE_RIGHT3 = 12;
  public static final int SWIPE_RIGHT4 = 16;
  public static final int SWIPE_UP1 = 3;
  public static final int SWIPE_UP2 = 7;
  public static final int SWIPE_UP3 = 11;
  public static final int SWIPE_UP4 = 15;
  public static final int TAP2 = 18;
  public static final int TAP3 = 19;
  public static final int TAP4 = 20;
  public static final int TOUCH_EXPLORE = 21;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 21;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private Gesture() {}
}
