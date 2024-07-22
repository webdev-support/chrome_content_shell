package org.chromium.ui.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ImeTextSpanType {
  public static final int AUTOCORRECT = 3;
  public static final int COMPOSITION = 0;
  public static final int GRAMMAR_SUGGESTION = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int MISSPELLING_SUGGESTION = 2;
  public static final int SUGGESTION = 1;

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

  private ImeTextSpanType() {}
}
