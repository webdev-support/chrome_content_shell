package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class InspectorIssueCode {
  public static final int ATTRIBUTION_REPORTING_ISSUE = 6;
  public static final int BLOCKED_BY_RESPONSE_ISSUE = 2;
  public static final int BOUNCE_TRACKING_ISSUE = 9;
  public static final int CONTENT_SECURITY_POLICY_ISSUE = 3;
  public static final int COOKIE_DEPRECATION_METADATA_ISSUE = 10;
  public static final int COOKIE_ISSUE = 0;
  public static final int DEPRECATION_ISSUE = 12;
  public static final int FEDERATED_AUTH_REQUEST_ISSUE = 8;
  public static final int FEDERATED_AUTH_USER_INFO_REQUEST_ISSUE = 13;
  public static final int GENERIC_ISSUE = 11;
  public static final int HEAVY_AD_ISSUE = 5;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LOW_TEXT_CONTRAST_ISSUE = 7;
  public static final int MAX_VALUE = 13;
  public static final int MIN_VALUE = 0;
  public static final int MIXED_CONTENT_ISSUE = 1;
  public static final int SHARED_ARRAY_BUFFER_ISSUE = 4;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 13;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private InspectorIssueCode() {}
}
