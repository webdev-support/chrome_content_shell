package org.chromium.ax.mojom;

public final class IntAttribute {
  public static final int ACTIVEDESCENDANT_ID = 31;
  public static final int ARIA_CELL_COLUMN_INDEX = 11;
  public static final int ARIA_CELL_COLUMN_SPAN = 12;
  public static final int ARIA_CELL_ROW_INDEX = 14;
  public static final int ARIA_CELL_ROW_SPAN = 15;
  public static final int ARIA_COLUMN_COUNT = 10;
  public static final int ARIA_CURRENT_STATE = 42;
  public static final int ARIA_ROW_COUNT = 13;
  public static final int BACKGROUND_COLOR = 43;
  public static final int CHECKED_STATE = 48;
  public static final int COLOR = 44;
  public static final int COLOR_VALUE = 41;
  public static final int DEFAULT_ACTION_VERB = 1;
  public static final int DEFAULT_VALUE = 0;
  public static final int DESCRIPTION_FROM = 30;
  public static final int DOM_NODE_ID = 60;
  public static final int DROPEFFECT_DEPRECATED = 59;
  public static final int ERRORMESSAGE_ID_DEPRECATED = 32;
  public static final int HAS_POPUP = 45;
  public static final int HIERARCHICAL_LEVEL = 28;
  public static final int IMAGE_ANNOTATION_STATUS = 46;
  public static final int INVALID_STATE = 47;
  public static final int IN_PAGE_LINK_TARGET_ID = 33;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int IS_POPUP = 61;
  public static final int LIST_STYLE = 49;
  public static final int MAX_VALUE = 63;
  public static final int MEMBER_OF_ID = 34;
  public static final int MIN_VALUE = 0;
  public static final int NAME_FROM = 29;
  public static final int NEXT_FOCUS_ID = 58;
  public static final int NEXT_ON_LINE_ID = 35;
  public static final int NEXT_WINDOW_FOCUS_ID = 62;
  public static final int NONE = 0;
  public static final int POPUP_FOR_ID = 36;
  public static final int POS_IN_SET = 40;
  public static final int PREVIOUS_FOCUS_ID = 57;
  public static final int PREVIOUS_ON_LINE_ID = 37;
  public static final int PREVIOUS_WINDOW_FOCUS_ID = 63;
  public static final int RESTRICTION = 38;
  public static final int SCROLL_X = 2;
  public static final int SCROLL_X_MAX = 4;
  public static final int SCROLL_X_MIN = 3;
  public static final int SCROLL_Y = 5;
  public static final int SCROLL_Y_MAX = 7;
  public static final int SCROLL_Y_MIN = 6;
  public static final int SET_SIZE = 39;
  public static final int SORT_DIRECTION = 27;
  public static final int TABLE_CELL_COLUMN_INDEX = 23;
  public static final int TABLE_CELL_COLUMN_SPAN = 24;
  public static final int TABLE_CELL_ROW_INDEX = 25;
  public static final int TABLE_CELL_ROW_SPAN = 26;
  public static final int TABLE_COLUMN_COUNT = 17;
  public static final int TABLE_COLUMN_HEADER_ID = 22;
  public static final int TABLE_COLUMN_INDEX = 21;
  public static final int TABLE_HEADER_ID = 18;
  public static final int TABLE_ROW_COUNT = 16;
  public static final int TABLE_ROW_HEADER_ID = 20;
  public static final int TABLE_ROW_INDEX = 19;
  public static final int TEXT_ALIGN = 50;
  public static final int TEXT_DIRECTION = 51;
  public static final int TEXT_OVERLINE_STYLE = 54;
  public static final int TEXT_POSITION = 52;
  public static final int TEXT_SEL_END = 9;
  public static final int TEXT_SEL_START = 8;
  public static final int TEXT_STRIKETHROUGH_STYLE = 55;
  public static final int TEXT_STYLE = 53;
  public static final int TEXT_UNDERLINE_STYLE = 56;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 63;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private IntAttribute() {}
}
