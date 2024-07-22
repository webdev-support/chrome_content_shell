package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class MediaPlayerActionType {
  public static final int CONTROLS = 1;
  public static final int COPY_VIDEO_FRAME = 3;
  public static final int DEFAULT_ACTION_TYPE = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LOOP = 0;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int PICTURE_IN_PICTURE = 4;
  public static final int SAVE_VIDEO_FRAME_AS = 2;

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

  private MediaPlayerActionType() {}
}
