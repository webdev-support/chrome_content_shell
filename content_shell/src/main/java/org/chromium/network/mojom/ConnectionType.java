package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ConnectionType {
  public static final int CONNECTION_2G = 3;
  public static final int CONNECTION_3G = 4;
  public static final int CONNECTION_4G = 5;
  public static final int CONNECTION_5G = 8;
  public static final int CONNECTION_BLUETOOTH = 7;
  public static final int CONNECTION_ETHERNET = 1;
  public static final int CONNECTION_LAST = 8;
  public static final int CONNECTION_NONE = 6;
  public static final int CONNECTION_UNKNOWN = 0;
  public static final int CONNECTION_WIFI = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 8;
  public static final int MIN_VALUE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 8;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private ConnectionType() {}
}
