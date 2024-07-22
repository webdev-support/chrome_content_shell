package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class BufferingState {
  private static final boolean IS_EXTENSIBLE = false;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return false;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private BufferingState() {}
}
