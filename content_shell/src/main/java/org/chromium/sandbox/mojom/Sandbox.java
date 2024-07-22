package org.chromium.sandbox.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class Sandbox {
  public static final int AUDIO = 3;
  public static final int CDM = 4;
  public static final int GPU = 8;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 11;
  public static final int MIN_VALUE = 0;
  public static final int NETWORK = 5;
  public static final int NO_SANDBOX = 7;
  public static final int ON_DEVICE_MODEL_EXECUTION = 6;
  public static final int PRINT_COMPOSITOR = 9;
  public static final int RENDERER = 10;
  public static final int SERVICE = 0;
  public static final int SERVICE_WITH_JIT = 1;
  public static final int SPEECH_RECOGNITION = 11;
  public static final int UTILITY = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 11;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private Sandbox() {}
}
