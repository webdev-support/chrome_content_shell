package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class FrameOwnerElementType {
  public static final int EMBED = 3;
  public static final int FENCEDFRAME = 5;
  public static final int FRAME = 4;
  public static final int IFRAME = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int OBJECT = 2;

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

  private FrameOwnerElementType() {}
}
