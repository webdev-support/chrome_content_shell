package org.chromium.mojo_base.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class AbslStatusCode {
  public static final int ABORTED = 10;
  public static final int ALREADY_EXISTS = 6;
  public static final int CANCELLED = 1;
  public static final int DATA_LOSS = 15;
  public static final int DEADLINE_EXCEEDED = 4;
  public static final int FAILED_PRECONDITION = 9;
  public static final int INTERNAL = 13;
  public static final int INVALID_ARGUMENT = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 16;
  public static final int MIN_VALUE = 0;
  public static final int NOT_FOUND = 5;
  public static final int OK = 0;
  public static final int OUT_OF_RANGE = 11;
  public static final int PERMISSION_DENIED = 7;
  public static final int RESOURCE_EXHAUSTED = 8;
  public static final int UNAUTHENTICATED = 16;
  public static final int UNAVAILABLE = 14;
  public static final int UNIMPLEMENTED = 12;
  public static final int UNKNOWN = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 16;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private AbslStatusCode() {}
}
