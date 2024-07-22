package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class SuddenTerminationDisablerType {
  public static final int BEFORE_UNLOAD_HANDLER = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int PAGE_HIDE_HANDLER = 1;
  public static final int UNLOAD_HANDLER = 2;
  public static final int VISIBILITY_CHANGE_HANDLER = 3;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 3;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private SuddenTerminationDisablerType() {}
}
