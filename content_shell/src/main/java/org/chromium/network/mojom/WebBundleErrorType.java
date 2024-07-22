package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class WebBundleErrorType {
  public static final int DEPRECATION_WARNING = 7;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 7;
  public static final int MEMORY_QUOTA_EXCEEDED = 3;
  public static final int METADATA_PARSE_ERROR = 0;
  public static final int MIN_VALUE = 0;
  public static final int RESOURCE_NOT_FOUND = 2;
  public static final int RESPONSE_PARSE_ERROR = 1;
  public static final int SERVING_CONSTRAINTS_NOT_MET = 4;
  public static final int WEB_BUNDLE_FETCH_FAILED = 5;
  public static final int WEB_BUNDLE_REDIRECTED = 6;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 7;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private WebBundleErrorType() {}
}
