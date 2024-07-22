package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ContentSecurityPolicyViolationType {
  public static final int EVAL_VIOLATION = 1;
  public static final int INLINE_VIOLATION = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int TRUSTED_TYPES_POLICY_VIOLATION = 4;
  public static final int TRUSTED_TYPES_SINK_VIOLATION = 3;
  public static final int URL_VIOLATION = 2;
  public static final int WASM_EVAL_VIOLATION = 5;

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

  private ContentSecurityPolicyViolationType() {}
}
