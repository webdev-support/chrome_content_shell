package org.chromium.proxy_resolver.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class HostResolveOperation {
  public static final int DNS_RESOLVE = 0;
  public static final int DNS_RESOLVE_EX = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int MY_IP_ADDRESS = 2;
  public static final int MY_IP_ADDRESS_EX = 3;

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

  private HostResolveOperation() {}
}
