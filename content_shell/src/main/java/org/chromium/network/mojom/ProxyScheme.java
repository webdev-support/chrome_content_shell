package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ProxyScheme {
  public static final int HTTP = 1;
  public static final int HTTPS = 4;
  public static final int INVALID = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int QUIC = 5;
  public static final int SOCKS4 = 2;
  public static final int SOCKS5 = 3;

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

  private ProxyScheme() {}
}
