package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class InsecureRequestPolicy {
  public static final int BLOCK_ALL_MIXED_CONTENT = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LEAVE_INSECURE_REQUESTS_ALONE = 0;
  public static final int MAX_INSECURE_REQUEST_POLICY = 3;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int UPGRADE_INSECURE_REQUESTS = 1;

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

  private InsecureRequestPolicy() {}
}
