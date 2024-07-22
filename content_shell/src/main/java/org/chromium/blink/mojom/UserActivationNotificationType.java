package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class UserActivationNotificationType {
  public static final int DEV_TOOLS = 2;
  public static final int EXTENSION_EVENT = 3;
  public static final int EXTENSION_GUEST_VIEW = 4;
  public static final int EXTENSION_MESSAGING = 5;
  public static final int EXTENSION_MESSAGING_BOTH_PRIVILEGED = 12;
  public static final int EXTENSION_MESSAGING_NEITHER_PRIVILEGED = 15;
  public static final int EXTENSION_MESSAGING_RECEIVER_PRIVILEGED = 14;
  public static final int EXTENSION_MESSAGING_SENDER_PRIVILEGED = 13;
  public static final int FILE_SYSTEM_ACCESS = 7;
  public static final int INTERACTION = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 15;
  public static final int MEDIA = 6;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int PLUGIN = 8;
  public static final int TEST = 9;
  public static final int VOICE_SEARCH = 11;
  public static final int WEB_SCRIPT_EXEC = 10;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 15;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private UserActivationNotificationType() {}
}
