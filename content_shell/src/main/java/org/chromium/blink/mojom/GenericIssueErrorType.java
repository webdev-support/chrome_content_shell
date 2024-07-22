package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class GenericIssueErrorType {
  public static final int CROSS_ORIGIN_PORTAL_POST_MESSAGE_ERROR = 0;
  public static final int FORM_ARIA_LABELLED_BY_TO_NON_EXISTING_ID = 6;
  public static final int FORM_AUTOCOMPLETE_ATTRIBUTE_EMPTY_ERROR = 4;
  public static final int FORM_DUPLICATE_ID_FOR_INPUT_ERROR = 2;
  public static final int FORM_EMPTY_ID_AND_NAME_ATTRIBUTES_FOR_INPUT_ERROR = 5;

  public static final int f433x764d19e9 = 7;
  public static final int FORM_INPUT_HAS_WRONG_BUT_WELL_INTENDED_AUTOCOMPLETE_VALUE_ERROR = 10;
  public static final int FORM_INPUT_WITH_NO_LABEL_ERROR = 3;
  public static final int FORM_LABEL_FOR_MATCHES_NON_EXISTING_ID_ERROR = 9;
  public static final int FORM_LABEL_FOR_NAME_ERROR = 1;
  public static final int FORM_LABEL_HAS_NEITHER_FOR_NOR_NESTED_INPUT = 8;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 11;
  public static final int MIN_VALUE = 0;
  public static final int RESPONSE_WAS_BLOCKED_BY_ORB = 11;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 11;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private GenericIssueErrorType() {}
}
