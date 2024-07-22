package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class PermissionName {
  public static final int ACCESSIBILITY_EVENTS = 9;
  public static final int AUDIO_CAPTURE = 5;
  public static final int BACKGROUND_FETCH = 13;
  public static final int BACKGROUND_SYNC = 7;
  public static final int CAPTURED_SURFACE_CONTROL = 24;
  public static final int CLIPBOARD_READ = 10;
  public static final int CLIPBOARD_WRITE = 11;
  public static final int DISPLAY_CAPTURE = 22;
  public static final int DURABLE_STORAGE = 4;
  public static final int GEOLOCATION = 0;
  public static final int IDLE_DETECTION = 14;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LOCAL_FONTS = 21;
  public static final int MAX_VALUE = 25;
  public static final int MIDI = 2;
  public static final int MIN_VALUE = 0;
  public static final int NFC = 18;
  public static final int NOTIFICATIONS = 1;
  public static final int PAYMENT_HANDLER = 12;
  public static final int PERIODIC_BACKGROUND_SYNC = 15;
  public static final int PROTECTED_MEDIA_IDENTIFIER = 3;
  public static final int SCREEN_WAKE_LOCK = 16;
  public static final int SENSORS = 8;
  public static final int SPEAKER_SELECTION = 25;
  public static final int STORAGE_ACCESS = 19;
  public static final int SYSTEM_WAKE_LOCK = 17;
  public static final int TOP_LEVEL_STORAGE_ACCESS = 23;
  public static final int VIDEO_CAPTURE = 6;
  public static final int WINDOW_MANAGEMENT = 20;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 25;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private PermissionName() {}
}
