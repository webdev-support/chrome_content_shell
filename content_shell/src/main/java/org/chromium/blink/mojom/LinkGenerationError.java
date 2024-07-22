package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class LinkGenerationError {
  public static final int BLOCK_LIST = 12;
  public static final int CONTEXT_EXHAUSTED = 3;
  public static final int CONTEXT_LIMIT_REACHED = 4;
  public static final int EMPTY_SELECTION = 5;
  public static final int INCORRECT_SELECTOR = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int I_FRAME = 10;
  public static final int MAX_VALUE = 14;
  public static final int MIN_VALUE = -1;
  public static final int NONE = -1;
  public static final int NOT_GENERATED = 14;
  public static final int NO_CONTEXT = 2;
  public static final int NO_RANGE = 1;
  public static final int NO_REMOTE_CONNECTION = 13;
  public static final int OMNIBOX_NAVIGATION = 7;
  public static final int TAB_CRASH = 8;
  public static final int TAB_HIDDEN = 6;
  public static final int TIMEOUT = 11;
  public static final int UNKNOWN = 9;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= -1 && value <= 14;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private LinkGenerationError() {}
}
