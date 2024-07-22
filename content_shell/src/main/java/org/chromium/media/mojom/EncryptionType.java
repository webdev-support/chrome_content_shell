package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class EncryptionType {
  public static final int CLEAR = 1;
  public static final int ENCRYPTED = 2;
  public static final int ENCRYPTED_WITH_CLEAR_LEAD = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;

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

  private EncryptionType() {}
}
