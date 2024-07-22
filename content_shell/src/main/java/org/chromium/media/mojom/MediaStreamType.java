package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class MediaStreamType {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LOCAL_DESKTOP_CAPTURE = 3;
  public static final int LOCAL_DEVICE_CAPTURE = 1;
  public static final int LOCAL_DISPLAY_CAPTURE = 4;
  public static final int LOCAL_ELEMENT_CAPTURE = 0;
  public static final int LOCAL_TAB_CAPTURE = 2;
  public static final int MAX_VALUE = 6;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 6;
  public static final int REMOTE = 5;

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

  private MediaStreamType() {}
}
