package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class FilterType {
  public static final int ALPHA_THRESHOLD = 14;
  public static final int BLUR = 8;
  public static final int BRIGHTNESS = 5;
  public static final int COLOR_MATRIX = 10;
  public static final int CONTRAST = 6;
  public static final int DROP_SHADOW = 9;
  public static final int FILTER_TYPE_LAST = 15;
  public static final int GRAYSCALE = 0;
  public static final int HUE_ROTATE = 3;
  public static final int INVERT = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 15;
  public static final int MIN_VALUE = 0;
  public static final int OFFSET = 15;
  public static final int OPACITY = 7;
  public static final int REFERENCE = 12;
  public static final int SATURATE = 2;
  public static final int SATURATING_BRIGHTNESS = 13;
  public static final int SEPIA = 1;
  public static final int ZOOM = 11;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 15;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private FilterType() {}
}
