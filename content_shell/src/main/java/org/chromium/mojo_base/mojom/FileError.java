package org.chromium.mojo_base.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class FileError {
  public static final int ABORT = -12;
  public static final int ACCESS_DENIED = -5;
  public static final int EXISTS = -3;
  public static final int FAILED = -1;
  public static final int INVALID_OPERATION = -10;
  public static final int INVALID_URL = -15;
  public static final int IN_USE = -2;

  public static final int f685IO = -16;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 0;
  public static final int MIN_VALUE = -16;
  public static final int NOT_A_DIRECTORY = -9;
  public static final int NOT_A_FILE = -13;
  public static final int NOT_EMPTY = -14;
  public static final int NOT_FOUND = -4;
  public static final int NO_MEMORY = -7;
  public static final int NO_SPACE = -8;

  public static final int f686OK = 0;
  public static final int SECURITY = -11;
  public static final int TOO_MANY_OPENED = -6;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= -16 && value <= 0;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private FileError() {}
}
