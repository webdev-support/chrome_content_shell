package org.chromium.ax.mojom;

public final class IntListAttribute {
  public static final int CARET_BOUNDS = 16;
  public static final int CHARACTER_OFFSETS = 11;
  public static final int CONTROLS_IDS = 2;
  public static final int CUSTOM_ACTION_IDS = 15;
  public static final int DEFAULT_VALUE = 0;
  public static final int DESCRIBEDBY_IDS = 4;
  public static final int DETAILS_IDS = 3;
  public static final int ERRORMESSAGE_IDS = 26;
  public static final int FLOWTO_IDS = 5;
  public static final int HIGHLIGHT_TYPES = 20;
  public static final int INDIRECT_CHILD_IDS = 1;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int LABELLEDBY_IDS = 6;
  public static final int LINE_ENDS = 17;
  public static final int LINE_STARTS = 12;
  public static final int MARKER_ENDS = 10;
  public static final int MARKER_STARTS = 9;
  public static final int MARKER_TYPES = 8;
  public static final int MAX_VALUE = 26;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int RADIO_GROUP_IDS = 7;
  public static final int SENTENCE_ENDS = 19;
  public static final int SENTENCE_STARTS = 18;
  public static final int TEXT_OPERATIONS = 25;
  public static final int TEXT_OPERATION_END_ANCHOR_IDS = 23;
  public static final int TEXT_OPERATION_END_OFFSETS = 24;
  public static final int TEXT_OPERATION_START_ANCHOR_IDS = 21;
  public static final int TEXT_OPERATION_START_OFFSETS = 22;
  public static final int WORD_ENDS = 14;
  public static final int WORD_STARTS = 13;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 26;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private IntListAttribute() {}
}
