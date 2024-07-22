package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ResourceType {
  public static final int CSP_REPORT = 16;
  public static final int FAVICON = 12;
  public static final int FONT_RESOURCE = 5;
  public static final int IMAGE = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int JSON = 21;
  public static final int MAIN_FRAME = 0;
  public static final int MAX_VALUE = 21;
  public static final int MEDIA = 8;
  public static final int MIN_VALUE = 0;
  public static final int NAVIGATION_PRELOAD_MAIN_FRAME = 19;
  public static final int NAVIGATION_PRELOAD_SUB_FRAME = 20;
  public static final int OBJECT = 7;
  public static final int PING = 14;
  public static final int PLUGIN_RESOURCE = 17;
  public static final int PREFETCH = 11;
  public static final int SCRIPT = 3;
  public static final int SERVICE_WORKER = 15;
  public static final int SHARED_WORKER = 10;
  public static final int STYLESHEET = 2;
  public static final int SUB_FRAME = 1;
  public static final int SUB_RESOURCE = 6;
  public static final int WORKER = 9;
  public static final int XHR = 13;

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
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      case 19:
      case 20:
      case 21:
        return true;
      case 18:
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

  private ResourceType() {}
}
