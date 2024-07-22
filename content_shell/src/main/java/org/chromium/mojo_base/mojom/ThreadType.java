package org.chromium.mojo_base.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ThreadType {
  public static final int BACKGROUND = 0;
  public static final int COMPOSITING = 4;
  public static final int DEFAULT = 3;
  public static final int DISPLAY_CRITICAL = 5;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 6;
  public static final int MIN_VALUE = 0;
  public static final int REALTIME_AUDIO = 6;
  public static final int RESOURCE_EFFICIENT = 2;
  public static final int UTILITY = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 6;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private ThreadType() {}
}
