package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class TrustTokenProtocolVersion {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int PRIVATE_STATE_TOKEN_V1_PMB = 2;
  public static final int PRIVATE_STATE_TOKEN_V1_VOPRF = 3;
  public static final int TRUST_TOKEN_V3_PMB = 0;
  public static final int TRUST_TOKEN_V3_VOPRF = 1;

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

  private TrustTokenProtocolVersion() {}
}
