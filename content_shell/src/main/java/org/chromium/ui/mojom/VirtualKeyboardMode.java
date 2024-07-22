package org.chromium.ui.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class VirtualKeyboardMode {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int OVERLAYS_CONTENT = 3;
  public static final int RESIZES_CONTENT = 2;
  public static final int RESIZES_VISUAL = 1;
  public static final int UNSET = 0;

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

  private VirtualKeyboardMode() {}
}
