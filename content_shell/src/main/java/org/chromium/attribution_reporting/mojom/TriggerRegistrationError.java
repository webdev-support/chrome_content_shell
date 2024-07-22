package org.chromium.attribution_reporting.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class TriggerRegistrationError {
  public static final int AGGREGATABLE_DEDUP_KEY_LIST_WRONG_TYPE = 31;
  public static final int AGGREGATABLE_DEDUP_KEY_VALUE_INVALID = 32;
  public static final int AGGREGATABLE_DEDUP_KEY_WRONG_TYPE = 33;
  public static final int AGGREGATABLE_SOURCE_REGISTRATION_TIME_UNKNOWN_VALUE = 35;
  public static final int AGGREGATABLE_SOURCE_REGISTRATION_TIME_WRONG_TYPE = 34;
  public static final int AGGREGATABLE_TRIGGER_DATA_KEY_PIECE_MISSING = 17;
  public static final int AGGREGATABLE_TRIGGER_DATA_KEY_PIECE_WRONG_FORMAT = 19;
  public static final int AGGREGATABLE_TRIGGER_DATA_KEY_PIECE_WRONG_TYPE = 18;
  public static final int AGGREGATABLE_TRIGGER_DATA_LIST_WRONG_TYPE = 14;
  public static final int AGGREGATABLE_TRIGGER_DATA_SOURCE_KEYS_KEY_TOO_LONG = 23;
  public static final int AGGREGATABLE_TRIGGER_DATA_SOURCE_KEYS_KEY_WRONG_TYPE = 22;
  public static final int AGGREGATABLE_TRIGGER_DATA_SOURCE_KEYS_WRONG_TYPE = 20;
  public static final int AGGREGATABLE_TRIGGER_DATA_WRONG_TYPE = 16;
  public static final int AGGREGATABLE_VALUES_KEY_TOO_LONG = 11;
  public static final int AGGREGATABLE_VALUES_LIST_VALUES_FIELD_MISSING = 40;
  public static final int AGGREGATABLE_VALUES_LIST_WRONG_TYPE = 39;
  public static final int AGGREGATABLE_VALUES_VALUE_OUT_OF_RANGE = 13;
  public static final int AGGREGATABLE_VALUES_VALUE_WRONG_TYPE = 12;
  public static final int AGGREGATABLE_VALUES_WRONG_TYPE = 9;
  public static final int AGGREGATION_COORDINATOR_UNKNOWN_VALUE = 30;
  public static final int AGGREGATION_COORDINATOR_WRONG_TYPE = 29;
  public static final int EVENT_DEDUP_KEY_VALUE_INVALID = 28;
  public static final int EVENT_PRIORITY_VALUE_INVALID = 27;
  public static final int EVENT_TRIGGER_DATA_LIST_WRONG_TYPE = 24;
  public static final int EVENT_TRIGGER_DATA_VALUE_INVALID = 25;
  public static final int EVENT_TRIGGER_DATA_WRONG_TYPE = 26;
  public static final int FILTERS_LIST_WRONG_TYPE = 5;
  public static final int FILTERS_USING_RESERVED_KEY = 36;
  public static final int FILTERS_VALUE_WRONG_TYPE = 7;
  public static final int FILTERS_WRONG_TYPE = 2;
  public static final int INVALID_JSON = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 40;
  public static final int MIN_VALUE = 0;
  public static final int ROOT_WRONG_TYPE = 1;
  public static final int TRIGGER_CONTEXT_ID_INVALID_SOURCE_REGISTRATION_TIME_CONFIG = 38;
  public static final int TRIGGER_CONTEXT_ID_INVALID_VALUE = 37;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    switch (value) {
      case 0:
      case 1:
      case 2:
      case 5:
      case 7:
      case 9:
      case 11:
      case 12:
      case 13:
      case 14:
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      case 33:
      case 34:
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:
      case 40:
        return true;
      case 3:
      case 4:
      case 6:
      case 8:
      case 10:
      case 15:
      case 21:
      default:
        return false;
    }
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private TriggerRegistrationError() {}
}
