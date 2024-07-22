package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CustomContextMenuItemType {
  public static final int CHECKABLE_OPTION = 1;
  public static final int GROUP = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int OPTION = 0;
  public static final int SEPARATOR = 3;
  public static final int SUB_MENU = 4;

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

  private CustomContextMenuItemType() {}
}
