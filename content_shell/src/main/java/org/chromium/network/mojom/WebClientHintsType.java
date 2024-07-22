package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class WebClientHintsType {
  public static final int DEVICE_MEMORY = 19;
  public static final int DEVICE_MEMORY_DEPRECATED = 0;
  public static final int DOWNLINK_DEPRECATED = 5;
  public static final int DPR = 20;
  public static final int DPR_DEPRECATED = 1;
  public static final int ECT_DEPRECATED = 6;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 30;
  public static final int MIN_VALUE = 0;
  public static final int PREFERS_COLOR_SCHEME = 15;
  public static final int PREFERS_REDUCED_MOTION = 28;
  public static final int PREFERS_REDUCED_TRANSPARENCY = 30;
  public static final int RESOURCE_WIDTH = 21;
  public static final int RESOURCE_WIDTH_DEPRECATED = 2;
  public static final int RTT_DEPRECATED = 4;
  public static final int SAVE_DATA = 27;

  public static final int f709UA = 8;
  public static final int UA_ARCH = 9;
  public static final int UA_BITNESS = 16;
  public static final int UA_FORM_FACTOR = 29;
  public static final int UA_FULL_VERSION = 13;
  public static final int UA_FULL_VERSION_LIST = 23;
  public static final int UA_MOBILE = 12;
  public static final int UA_MODEL = 11;
  public static final int UA_PLATFORM = 10;
  public static final int UA_PLATFORM_VERSION = 14;
  public static final int UA_WO_W64 = 25;
  public static final int VIEWPORT_HEIGHT = 18;
  public static final int VIEWPORT_WIDTH = 22;
  public static final int VIEWPORT_WIDTH_DEPRECATED = 3;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    switch (value) {
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 18:
      case 19:
      case 20:
      case 21:
      case 22:
      case 23:
      case 25:
      case 27:
      case 28:
      case 29:
      case 30:
        return true;
      case 7:
      case 17:
      case 24:
      case 26:
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

  private WebClientHintsType() {}
}
