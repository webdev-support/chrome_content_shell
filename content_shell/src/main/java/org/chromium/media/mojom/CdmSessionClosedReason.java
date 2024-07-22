package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CdmSessionClosedReason {
  public static final int CLOSE = 1;
  public static final int HARDWARE_CONTEXT_RESET = 3;
  public static final int INTERNAL_ERROR = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int RELEASE_ACKNOWLEDGED = 2;
  public static final int RESOURCE_EVICTED = 4;

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

  private CdmSessionClosedReason() {}
}
