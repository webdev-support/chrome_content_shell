package org.chromium.media.mojom;

public final class VideoCaptureTransportType {
  public static final int APPLE_USB_OR_BUILT_IN = 0;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 1;
  public static final int MIN_VALUE = 0;
  public static final int OTHER_TRANSPORT = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 1;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    return value;
  }

  private VideoCaptureTransportType() {}
}
