package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class DeleteStoredTrustTokensStatus {
  public static final int FAILURE_FEATURE_DISABLED = 2;
  public static final int FAILURE_INVALID_ORIGIN = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int SUCCESS_NO_TOKENS_DELETED = 1;
  public static final int SUCCESS_TOKENS_DELETED = 0;

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

  private DeleteStoredTrustTokensStatus() {}
}
