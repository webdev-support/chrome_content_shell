package org.chromium.display.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ContentProtectionMethod {
  public static final int CONTENT_PROTECTION_METHOD_HDCP_TYPE_0 = 1;
  public static final int CONTENT_PROTECTION_METHOD_HDCP_TYPE_1 = 2;
  public static final int CONTENT_PROTECTION_METHOD_NONE = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 2;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private ContentProtectionMethod() {}
}
