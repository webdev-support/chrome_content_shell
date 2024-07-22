package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class MediaStreamRequestResult {
  public static final int CAPTURE_FAILURE = 8;
  public static final int CONSTRAINT_NOT_SATISFIED = 9;
  public static final int DEVICE_IN_USE = 16;
  public static final int FAILED_DUE_TO_SHUTDOWN = 13;
  public static final int INVALID_SECURITY_ORIGIN = 5;
  public static final int INVALID_STATE = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int KILL_SWITCH_ON = 14;
  public static final int MAX_VALUE = 18;
  public static final int MIN_VALUE = 0;
  public static final int NOT_SUPPORTED = 12;
  public static final int NO_HARDWARE = 4;
  public static final int NUM_MEDIA_REQUEST_RESULTS = 18;

  public static final int f440OK = 0;
  public static final int PERMISSION_DENIED = 1;
  public static final int PERMISSION_DISMISSED = 2;
  public static final int REQUEST_CANCELLED = 17;
  public static final int SCREEN_CAPTURE_FAILURE = 7;
  public static final int SYSTEM_PERMISSION_DENIED = 15;
  public static final int TAB_CAPTURE_FAILURE = 6;
  public static final int TRACK_START_FAILURE_AUDIO = 10;
  public static final int TRACK_START_FAILURE_VIDEO = 11;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 18;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private MediaStreamRequestResult() {}
}
