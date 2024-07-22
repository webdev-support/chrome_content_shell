package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class EditingBehavior {
  public static final int EDITING_ANDROID_BEHAVIOR = 3;
  public static final int EDITING_CHROME_OS_BEHAVIOR = 4;
  public static final int EDITING_MAC_BEHAVIOR = 0;
  public static final int EDITING_UNIX_BEHAVIOR = 2;
  public static final int EDITING_WINDOWS_BEHAVIOR = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 4;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private EditingBehavior() {}
}
