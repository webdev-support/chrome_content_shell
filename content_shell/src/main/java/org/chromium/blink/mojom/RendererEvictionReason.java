package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class RendererEvictionReason {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int JAVA_SCRIPT_EXECUTION = 0;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int NETWORK_EXCEEDS_BUFFER_LIMIT = 4;
  public static final int NETWORK_REQUEST_DATAPIPE_DRAINED_AS_BYTES_CONSUMER = 1;
  public static final int NETWORK_REQUEST_REDIRECTED = 2;
  public static final int NETWORK_REQUEST_TIMEOUT = 3;

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

  private RendererEvictionReason() {}
}
