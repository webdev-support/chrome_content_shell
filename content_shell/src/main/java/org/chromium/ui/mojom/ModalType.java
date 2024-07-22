package org.chromium.ui.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ModalType {
  public static final int CHILD = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int SYSTEM = 3;
  public static final int WINDOW = 1;

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

  private ModalType() {}
}
