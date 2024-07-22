package org.chromium.display.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class DisplayConnectionType {
  public static final int DISPLAY_CONNECTION_TYPE_DISPLAYPORT = 32;
  public static final int DISPLAY_CONNECTION_TYPE_DVI = 16;
  public static final int DISPLAY_CONNECTION_TYPE_HDMI = 8;
  public static final int DISPLAY_CONNECTION_TYPE_INTERNAL = 2;
  public static final int DISPLAY_CONNECTION_TYPE_NETWORK = 64;
  public static final int DISPLAY_CONNECTION_TYPE_NONE = 0;
  public static final int DISPLAY_CONNECTION_TYPE_UNKNOWN = 1;
  public static final int DISPLAY_CONNECTION_TYPE_VGA = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 64;
  public static final int MIN_VALUE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    switch (value) {
      case 0:
      case 1:
      case 2:
      case 4:
      case 8:
      case 16:
      case 32:
      case 64:
        return true;
      default:
        return false;
    }
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private DisplayConnectionType() {}
}
