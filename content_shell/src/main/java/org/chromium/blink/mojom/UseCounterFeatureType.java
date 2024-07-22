package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class UseCounterFeatureType {
  public static final int ANIMATED_CSS_PROPERTY = 2;
  public static final int CSS_PROPERTY = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int PERMISSIONS_POLICY_HEADER = 5;
  public static final int PERMISSIONS_POLICY_IFRAME_ATTRIBUTE = 4;
  public static final int PERMISSIONS_POLICY_VIOLATION_ENFORCE = 3;
  public static final int WEB_FEATURE = 0;

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

  private UseCounterFeatureType() {}
}
