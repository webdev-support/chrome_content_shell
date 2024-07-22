package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class SwapResult {
  public static final int ACK = 0;
  public static final int FAILED = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int NAK_RECREATE_BUFFERS = 3;
  public static final int SKIPPED = 2;

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

  private SwapResult() {}
}
