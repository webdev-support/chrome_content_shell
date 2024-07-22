package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class FileSystemAccessStatus {
  public static final int FILE_ERROR = 10;
  public static final int INVALID_ARGUMENT = 7;
  public static final int INVALID_MODIFICATION_ERROR = 4;
  public static final int INVALID_STATE = 6;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 10;
  public static final int MIN_VALUE = 0;
  public static final int NOT_SUPPORTED_ERROR = 5;
  public static final int NO_MODIFICATION_ALLOWED_ERROR = 3;

  public static final int f428OK = 0;
  public static final int OPERATION_ABORTED = 9;
  public static final int OPERATION_FAILED = 8;
  public static final int PERMISSION_DENIED = 1;
  public static final int SECURITY_ERROR = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 10;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private FileSystemAccessStatus() {}
}
