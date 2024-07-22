package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class OverlayTransform {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 6;
  public static final int MIN_VALUE = 0;
  public static final int OVERLAY_TRANSFORM_FLIP_HORIZONTAL = 2;
  public static final int OVERLAY_TRANSFORM_FLIP_VERTICAL = 3;
  public static final int OVERLAY_TRANSFORM_INVALID = 0;
  public static final int OVERLAY_TRANSFORM_LAST = 6;
  public static final int OVERLAY_TRANSFORM_NONE = 1;
  public static final int OVERLAY_TRANSFORM_ROTATE_CLOCKWISE_180 = 5;
  public static final int OVERLAY_TRANSFORM_ROTATE_CLOCKWISE_270 = 6;
  public static final int OVERLAY_TRANSFORM_ROTATE_CLOCKWISE_90 = 4;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 6;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private OverlayTransform() {}
}
