package org.chromium.ax.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class NameFrom {
  public static final int ATTRIBUTE = 1;
  public static final int ATTRIBUTE_EXPLICITLY_EMPTY = 2;
  public static final int CAPTION = 3;
  public static final int CONTENTS = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 9;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int PLACEHOLDER = 5;
  public static final int POPOVER_ATTRIBUTE = 9;
  public static final int RELATED_ELEMENT = 6;
  public static final int TITLE = 7;
  public static final int VALUE = 8;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 9;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private NameFrom() {}
}
