package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class RequestContextType {
  public static final int ATTRIBUTION_SRC = 1;
  public static final int AUDIO = 2;
  public static final int BEACON = 3;
  public static final int CSP_REPORT = 4;
  public static final int DOWNLOAD = 5;
  public static final int EMBED = 6;
  public static final int EVENT_SOURCE = 7;
  public static final int FAVICON = 8;
  public static final int FETCH = 9;
  public static final int FONT = 10;
  public static final int FORM = 11;
  public static final int FRAME = 12;
  public static final int HYPERLINK = 13;
  public static final int IFRAME = 14;
  public static final int IMAGE = 15;
  public static final int IMAGE_SET = 16;
  public static final int INTERNAL = 17;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int JSON = 18;
  public static final int LOCATION = 19;
  public static final int MANIFEST = 20;
  public static final int MAX_VALUE = 36;
  public static final int MIN_VALUE = 0;
  public static final int OBJECT = 21;
  public static final int PING = 22;
  public static final int PLUGIN = 23;
  public static final int PREFETCH = 24;
  public static final int SCRIPT = 25;
  public static final int SERVICE_WORKER = 26;
  public static final int SHARED_WORKER = 27;
  public static final int SPECULATION_RULES = 28;
  public static final int STYLE = 31;
  public static final int SUBRESOURCE = 29;
  public static final int SUBRESOURCE_WEBBUNDLE = 30;
  public static final int TRACK = 32;
  public static final int UNSPECIFIED = 0;
  public static final int VIDEO = 33;
  public static final int WORKER = 34;
  public static final int XML_HTTP_REQUEST = 35;
  public static final int XSLT = 36;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 36;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private RequestContextType() {}
}
