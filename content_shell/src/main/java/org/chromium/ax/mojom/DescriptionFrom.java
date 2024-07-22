package org.chromium.ax.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class DescriptionFrom {
  public static final int ARIA_DESCRIPTION = 1;
  public static final int ATTRIBUTE_EXPLICITLY_EMPTY = 2;
  public static final int BUTTON_LABEL = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 10;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int POPOVER_ATTRIBUTE = 10;
  public static final int RELATED_ELEMENT = 4;
  public static final int RUBY_ANNOTATION = 5;
  public static final int SUMMARY = 6;
  public static final int SVG_DESC_ELEMENT = 7;
  public static final int TABLE_CAPTION = 8;
  public static final int TITLE = 9;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 10;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private DescriptionFrom() {}
}
