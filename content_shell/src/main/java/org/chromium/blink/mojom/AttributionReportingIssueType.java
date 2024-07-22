package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class AttributionReportingIssueType {
  public static final int INSECURE_CONTEXT = 2;
  public static final int INVALID_REGISTER_OS_SOURCE_HEADER = 10;
  public static final int INVALID_REGISTER_OS_TRIGGER_HEADER = 11;
  public static final int INVALID_REGISTER_SOURCE_HEADER = 3;
  public static final int INVALID_REGISTER_TRIGGER_HEADER = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 14;
  public static final int MIN_VALUE = 0;
  public static final int NAVIGATION_REGISTRATION_WITHOUT_TRANSIENT_USER_ACTIVATION = 14;
  public static final int NO_WEB_OR_OS_SUPPORT = 13;
  public static final int OS_SOURCE_IGNORED = 8;
  public static final int OS_TRIGGER_IGNORED = 9;
  public static final int PERMISSION_POLICY_DISABLED = 0;
  public static final int SOURCE_AND_TRIGGER_HEADERS = 5;
  public static final int SOURCE_IGNORED = 6;
  public static final int TRIGGER_IGNORED = 7;
  public static final int UNTRUSTWORTHY_REPORTING_ORIGIN = 1;
  public static final int WEB_AND_OS_HEADERS = 12;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 14;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private AttributionReportingIssueType() {}
}
