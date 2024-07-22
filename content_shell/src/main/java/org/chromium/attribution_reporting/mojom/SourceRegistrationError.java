package org.chromium.attribution_reporting.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class SourceRegistrationError {
  public static final int AGGREGATABLE_REPORT_WINDOW_VALUE_INVALID = 23;
  public static final int AGGREGATION_KEYS_KEY_TOO_LONG = 15;
  public static final int AGGREGATION_KEYS_TOO_MANY_KEYS = 14;
  public static final int AGGREGATION_KEYS_VALUE_WRONG_FORMAT = 17;
  public static final int AGGREGATION_KEYS_VALUE_WRONG_TYPE = 16;
  public static final int AGGREGATION_KEYS_WRONG_TYPE = 13;
  public static final int BOTH_EVENT_REPORT_WINDOW_FIELDS_FOUND = 36;
  public static final int DESTINATION_LIST_TOO_LONG = 18;
  public static final int DESTINATION_MISSING = 2;
  public static final int DESTINATION_UNTRUSTWORTHY = 4;
  public static final int DESTINATION_WRONG_TYPE = 3;
  public static final int DUPLICATE_TRIGGER_DATA = 47;
  public static final int EVENT_LEVEL_EPSILON_VALUE_INVALID = 59;
  public static final int EVENT_LEVEL_EPSILON_WRONG_TYPE = 58;
  public static final int EVENT_REPORT_WINDOWS_END_TIMES_LIST_EMPTY = 31;
  public static final int EVENT_REPORT_WINDOWS_END_TIMES_LIST_TOO_LONG = 32;
  public static final int EVENT_REPORT_WINDOWS_END_TIMES_MISSING = 29;
  public static final int EVENT_REPORT_WINDOWS_END_TIMES_WRONG_TYPE = 30;
  public static final int EVENT_REPORT_WINDOWS_END_TIME_DURATION_LTE_START = 35;
  public static final int EVENT_REPORT_WINDOWS_END_TIME_VALUE_INVALID = 34;
  public static final int EVENT_REPORT_WINDOWS_END_TIME_VALUE_WRONG_TYPE = 33;
  public static final int EVENT_REPORT_WINDOWS_START_TIME_INVALID = 28;
  public static final int EVENT_REPORT_WINDOWS_START_TIME_WRONG_TYPE = 27;
  public static final int EVENT_REPORT_WINDOWS_WRONG_TYPE = 26;
  public static final int EVENT_REPORT_WINDOW_VALUE_INVALID = 22;
  public static final int EXCESSIVE_TRIGGER_DATA = 46;
  public static final int EXPIRY_VALUE_INVALID = 21;
  public static final int FILTER_DATA_HAS_LOOKBACK_WINDOW_KEY = 24;
  public static final int FILTER_DATA_HAS_SOURCE_TYPE_KEY = 7;
  public static final int FILTER_DATA_KEY_RESERVED = 49;
  public static final int FILTER_DATA_KEY_TOO_LONG = 8;
  public static final int FILTER_DATA_LIST_TOO_LONG = 10;
  public static final int FILTER_DATA_LIST_WRONG_TYPE = 9;
  public static final int FILTER_DATA_TOO_MANY_KEYS = 6;
  public static final int FILTER_DATA_VALUE_TOO_LONG = 12;
  public static final int FILTER_DATA_VALUE_WRONG_TYPE = 11;
  public static final int FILTER_DATA_WRONG_TYPE = 5;
  public static final int INVALID_JSON = 0;
  public static final int INVALID_TRIGGER_DATA_FOR_MATCHING_MODE = 48;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_EVENT_LEVEL_REPORTS_VALUE_INVALID = 25;
  public static final int MAX_VALUE = 60;
  public static final int MIN_VALUE = 0;
  public static final int PRIORITY_VALUE_INVALID = 20;
  public static final int ROOT_WRONG_TYPE = 1;
  public static final int SOURCE_EVENT_ID_VALUE_INVALID = 19;
  public static final int SUMMARY_BUCKETS_EMPTY = 53;
  public static final int SUMMARY_BUCKETS_NON_INCREASING = 57;
  public static final int SUMMARY_BUCKETS_TOO_LONG = 54;
  public static final int SUMMARY_BUCKETS_VALUE_OUT_OF_RANGE = 56;
  public static final int SUMMARY_BUCKETS_VALUE_WRONG_TYPE = 55;
  public static final int SUMMARY_BUCKETS_WRONG_TYPE = 52;
  public static final int SUMMARY_WINDOW_OPERATOR_UNKNOWN_VALUE = 51;
  public static final int SUMMARY_WINDOW_OPERATOR_WRONG_TYPE = 50;
  public static final int TOP_LEVEL_TRIGGER_DATA_AND_TRIGGER_SPECS = 60;
  public static final int TRIGGER_DATA_MATCHING_UNKNOWN_VALUE = 38;
  public static final int TRIGGER_DATA_MATCHING_WRONG_TYPE = 37;
  public static final int TRIGGER_SPECS_WRONG_TYPE = 39;
  public static final int TRIGGER_SPEC_TRIGGER_DATA_EMPTY = 43;
  public static final int TRIGGER_SPEC_TRIGGER_DATA_MISSING = 41;
  public static final int TRIGGER_SPEC_TRIGGER_DATA_VALUE_OUT_OF_RANGE = 45;
  public static final int TRIGGER_SPEC_TRIGGER_DATA_VALUE_WRONG_TYPE = 44;
  public static final int TRIGGER_SPEC_TRIGGER_DATA_WRONG_TYPE = 42;
  public static final int TRIGGER_SPEC_WRONG_TYPE = 40;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 60;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private SourceRegistrationError() {}
}
