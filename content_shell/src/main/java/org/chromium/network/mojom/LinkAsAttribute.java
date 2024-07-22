package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class LinkAsAttribute {
  public static final int FETCH = 5;
  public static final int FONT = 1;
  public static final int IMAGE = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int SCRIPT = 3;
  public static final int STYLE_SHEET = 4;
  public static final int UNSPECIFIED = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 5;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private LinkAsAttribute() {}
}
