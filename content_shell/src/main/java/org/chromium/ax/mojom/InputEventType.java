package org.chromium.ax.mojom;

public final class InputEventType {
  public static final int DEFAULT_VALUE = 0;
  public static final int DELETE_BY_CUT = 21;
  public static final int DELETE_BY_DRAG = 22;
  public static final int DELETE_CONTENT_BACKWARD = 19;
  public static final int DELETE_CONTENT_FORWARD = 20;
  public static final int DELETE_HARD_LINE_BACKWARD = 17;
  public static final int DELETE_HARD_LINE_FORWARD = 18;
  public static final int DELETE_SOFT_LINE_BACKWARD = 15;
  public static final int DELETE_SOFT_LINE_FORWARD = 16;
  public static final int DELETE_WORD_BACKWARD = 13;
  public static final int DELETE_WORD_FORWARD = 14;
  public static final int FORMAT_BOLD = 25;
  public static final int FORMAT_INDENT = 35;
  public static final int FORMAT_ITALIC = 26;
  public static final int FORMAT_JUSTIFY_CENTER = 31;
  public static final int FORMAT_JUSTIFY_FULL = 32;
  public static final int FORMAT_JUSTIFY_LEFT = 34;
  public static final int FORMAT_JUSTIFY_RIGHT = 33;
  public static final int FORMAT_OUTDENT = 36;
  public static final int FORMAT_REMOVE = 37;
  public static final int FORMAT_SET_BLOCK_TEXT_DIRECTION = 38;
  public static final int FORMAT_STRIKE_THROUGH = 28;
  public static final int FORMAT_SUBSCRIPT = 30;
  public static final int FORMAT_SUPERSCRIPT = 29;
  public static final int FORMAT_UNDERLINE = 27;
  public static final int HISTORY_REDO = 24;
  public static final int HISTORY_UNDO = 23;
  public static final int INSERT_COMPOSITION_TEXT = 12;
  public static final int INSERT_FROM_DROP = 8;
  public static final int INSERT_FROM_PASTE = 7;
  public static final int INSERT_FROM_YANK = 9;
  public static final int INSERT_HORIZONTAL_RULE = 6;
  public static final int INSERT_LINE_BREAK = 2;
  public static final int INSERT_ORDERED_LIST = 4;
  public static final int INSERT_PARAGRAPH = 3;
  public static final int INSERT_REPLACEMENT_TEXT = 11;
  public static final int INSERT_TEXT = 1;
  public static final int INSERT_TRANSPOSE = 10;
  public static final int INSERT_UNORDERED_LIST = 5;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 38;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 38;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private InputEventType() {}
}
