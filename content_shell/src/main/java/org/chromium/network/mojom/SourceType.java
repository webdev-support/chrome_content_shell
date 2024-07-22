package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class SourceType {
  public static final int BROTLI = 0;
  public static final int DEFLATE = 1;
  public static final int GZIP = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 4;
  public static final int UNKNOWN = 5;
  public static final int ZSTD = 3;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 5;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private SourceType() {}
}
