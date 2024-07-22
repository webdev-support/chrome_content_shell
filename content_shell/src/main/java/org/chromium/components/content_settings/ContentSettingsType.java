package org.chromium.components.content_settings;

import org.chromium.mojo.bindings.DeserializationException;

public final class ContentSettingsType {
  public static final int ACCESSIBILITY_EVENTS = 33;
  public static final int ADS = 25;
  public static final int ADS_DATA = 26;
  public static final int ALL_SCREEN_CAPTURE = 87;
  public static final int ANTI_ABUSE = 84;
  public static final int APP_BANNER = 16;

  public static final int f540AR = 55;
  public static final int AUTOMATIC_DOWNLOADS = 12;
  public static final int AUTOMATIC_FULLSCREEN = 100;
  public static final int AUTOPLAY = 22;
  public static final int AUTO_DARK_WEB_CONTENT = 71;
  public static final int AUTO_PICTURE_IN_PICTURE = 93;
  public static final int AUTO_SELECT_CERTIFICATE = 6;
  public static final int BACKGROUND_FETCH = 36;
  public static final int BACKGROUND_SYNC = 21;
  public static final int BLUETOOTH_CHOOSER_DATA = 50;
  public static final int BLUETOOTH_GUARD = 20;
  public static final int BLUETOOTH_SCANNING = 42;
  public static final int CAMERA_PAN_TILT_ZOOM = 58;
  public static final int CAPTURED_SURFACE_CONTROL = 96;
  public static final int CLIENT_HINTS = 31;
  public static final int CLIPBOARD_READ_WRITE = 51;
  public static final int CLIPBOARD_SANITIZED_WRITE = 52;
  public static final int COOKIES = 0;
  public static final int COOKIE_CONTROLS_METADATA = 88;
  public static final int DEFAULT = -1;
  public static final int DEPRECATED_FEDERATED_IDENTITY_ACTIVE_SESSION = 70;
  public static final int DEPRECATED_PPAPI_BROKER = 11;
  public static final int DISPLAY_CAPTURE = 64;
  public static final int DURABLE_STORAGE = 18;
  public static final int FEDERATED_IDENTITY_API = 73;
  public static final int FEDERATED_IDENTITY_AUTO_REAUTHN_PERMISSION = 82;
  public static final int FEDERATED_IDENTITY_IDENTITY_PROVIDER_REGISTRATION = 83;
  public static final int FEDERATED_IDENTITY_IDENTITY_PROVIDER_SIGNIN_STATUS = 79;
  public static final int FEDERATED_IDENTITY_SHARING = 66;
  public static final int FILE_SYSTEM_ACCESS_CHOOSER_DATA = 65;
  public static final int FILE_SYSTEM_ACCESS_EXTENDED_PERMISSION = 94;
  public static final int FILE_SYSTEM_ACCESS_RESTORE_PERMISSION = 95;
  public static final int FILE_SYSTEM_LAST_PICKED_DIRECTORY = 63;
  public static final int FILE_SYSTEM_READ_GUARD = 56;
  public static final int FILE_SYSTEM_WRITE_GUARD = 48;
  public static final int FORMFILL_METADATA = 69;
  public static final int GEOLOCATION = 4;
  public static final int HID_CHOOSER_DATA = 44;
  public static final int HID_GUARD = 43;
  public static final int HTTPS_ENFORCED = 86;
  public static final int HTTP_ALLOWED = 68;
  public static final int IDLE_DETECTION = 38;
  public static final int IMAGES = 1;
  public static final int IMPORTANT_SITE_INFO = 23;
  public static final int INSECURE_PRIVATE_NETWORK = 60;
  public static final int INTENT_PICKER_DISPLAY = 37;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int JAVASCRIPT = 2;
  public static final int JAVASCRIPT_JIT = 67;
  public static final int LEGACY_COOKIE_ACCESS = 47;
  public static final int LOCAL_FONTS = 61;
  public static final int MAX_VALUE = 103;
  public static final int MEDIASTREAM_CAMERA = 9;
  public static final int MEDIASTREAM_MIC = 8;
  public static final int MEDIA_ENGAGEMENT = 29;
  public static final int MIDI = 27;
  public static final int MIDI_SYSEX = 13;
  public static final int MIN_VALUE = -1;
  public static final int MIXEDSCRIPT = 7;
  public static final int NFC = 49;
  public static final int NOTIFICATIONS = 5;
  public static final int NOTIFICATION_INTERACTIONS = 74;
  public static final int NOTIFICATION_PERMISSION_REVIEW = 76;
  public static final int NUM_TYPES = 103;
  public static final int PASSWORD_PROTECTION = 28;
  public static final int PAYMENT_HANDLER = 34;
  public static final int PERIODIC_BACKGROUND_SYNC = 41;
  public static final int PERMISSION_AUTOBLOCKER_DATA = 24;
  public static final int PERMISSION_AUTOREVOCATION_DATA = 62;
  public static final int POPUPS = 3;
  public static final int PRIVATE_NETWORK_CHOOSER_DATA = 78;
  public static final int PRIVATE_NETWORK_GUARD = 77;
  public static final int PROTECTED_MEDIA_IDENTIFIER = 15;
  public static final int PROTOCOL_HANDLERS = 10;
  public static final int REDUCED_ACCEPT_LANGUAGE = 75;
  public static final int REQUEST_DESKTOP_SITE = 72;
  public static final int REVOKED_UNUSED_SITE_PERMISSIONS = 80;
  public static final int SAFE_BROWSING_URL_CHECK_DATA = 53;
  public static final int SENSORS = 32;
  public static final int SERIAL_CHOOSER_DATA = 40;
  public static final int SERIAL_GUARD = 39;
  public static final int SITE_ENGAGEMENT = 17;
  public static final int SMART_CARD_DATA = 98;
  public static final int SMART_CARD_GUARD = 97;
  public static final int SOUND = 30;
  public static final int SPEAKER_SELECTION = 102;
  public static final int SSL_CERT_DECISIONS = 14;
  public static final int STORAGE_ACCESS = 57;
  public static final int SUB_APP_INSTALLATION_PROMPTS = 101;
  public static final int THIRD_PARTY_STORAGE_PARTITIONING = 85;
  public static final int TOP_LEVEL_STORAGE_ACCESS = 81;
  public static final int TOP_LEVEL_TPCD_TRIAL = 92;
  public static final int TPCD_HEURISTICS_GRANTS = 89;
  public static final int TPCD_METADATA_GRANTS = 90;
  public static final int TPCD_TRIAL = 91;
  public static final int USB_CHOOSER_DATA = 19;
  public static final int USB_GUARD = 35;

  public static final int f541VR = 54;
  public static final int WAKE_LOCK_SCREEN = 45;
  public static final int WAKE_LOCK_SYSTEM = 46;
  public static final int WEB_PRINTING = 99;
  public static final int WINDOW_MANAGEMENT = 59;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= -1 && value <= 103;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private ContentSettingsType() {}
}
