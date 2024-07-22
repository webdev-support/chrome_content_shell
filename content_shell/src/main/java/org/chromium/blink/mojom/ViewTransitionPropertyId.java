package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ViewTransitionPropertyId {
  public static final int BACKDROP_FILTER = 0;
  public static final int COLOR_SCHEME = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int MIX_BLEND_MODE = 2;
  public static final int TEXT_ORIENTATION = 3;
  public static final int WRITING_MODE = 4;

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

  private ViewTransitionPropertyId() {}
}
