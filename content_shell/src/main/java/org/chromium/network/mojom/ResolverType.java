package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ResolverType {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int RESOLVER_TYPE_DIRECT_LOOKUP = 4;
  public static final int RESOLVER_TYPE_FAIL = 0;
  public static final int RESOLVER_TYPE_FAIL_TIMEOUT = 1;
  public static final int RESOLVER_TYPE_IP_LITERAL = 3;
  public static final int RESOLVER_TYPE_SYSTEM = 2;

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

  private ResolverType() {}
}
