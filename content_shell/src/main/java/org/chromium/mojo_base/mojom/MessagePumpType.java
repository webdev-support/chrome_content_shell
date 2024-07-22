package org.chromium.mojo_base.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class MessagePumpType {
  public static final int CUSTOM = 2;
  public static final int DEFAULT = 0;

  public static final int f687IO = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int JAVA = 4;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;

  public static final int f688UI = 1;

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

  private MessagePumpType() {}
}
