package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ScrollDirection {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 7;
  public static final int MIN_VALUE = 0;
  public static final int SCROLL_BLOCK_DIRECTION_BACKWARD = 4;
  public static final int SCROLL_BLOCK_DIRECTION_FORWARD = 5;
  public static final int SCROLL_DOWN_IGNORING_WRITING_MODE = 1;
  public static final int SCROLL_INLINE_DIRECTION_BACKWARD = 6;
  public static final int SCROLL_INLINE_DIRECTION_FORWARD = 7;
  public static final int SCROLL_LEFT_IGNORING_WRITING_MODE = 2;
  public static final int SCROLL_RIGHT_IGNORING_WRITING_MODE = 3;
  public static final int SCROLL_UP_IGNORING_WRITING_MODE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 7;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private ScrollDirection() {}
}
