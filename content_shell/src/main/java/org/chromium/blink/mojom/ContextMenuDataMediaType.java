package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ContextMenuDataMediaType {
  public static final int AUDIO = 3;
  public static final int CANVAS = 4;
  public static final int FILE = 5;
  public static final int IMAGE = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 6;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int PLUGIN = 6;
  public static final int VIDEO = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 6;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private ContextMenuDataMediaType() {}
}
