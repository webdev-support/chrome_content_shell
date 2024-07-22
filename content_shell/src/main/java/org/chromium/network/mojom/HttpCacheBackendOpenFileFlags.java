package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class HttpCacheBackendOpenFileFlags {
  public static final int CREATE_ALWAYS_WRITE_WIN_SHARE_DELETE = 32840;
  public static final int CREATE_AND_WRITE = 66;
  public static final int CREATE_READ_WRITE_WIN_SHARE_DELETE = 32866;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 557089;
  public static final int MIN_VALUE = 33;
  public static final int OPEN_AND_READ = 33;
  public static final int OPEN_READ_WIN_SHARE_DELETE_WIN_SEQUENTIAL_SCAN = 557089;
  public static final int OPEN_READ_WRITE_WIN_SHARE_DELETE = 32865;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    switch (value) {
      case 33:
      case 66:
      case CREATE_ALWAYS_WRITE_WIN_SHARE_DELETE /* 32840 */:
      case OPEN_READ_WRITE_WIN_SHARE_DELETE /* 32865 */:
      case CREATE_READ_WRITE_WIN_SHARE_DELETE /* 32866 */:
      case 557089:
        return true;
      default:
        return false;
    }
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private HttpCacheBackendOpenFileFlags() {}
}
