package org.chromium.ax.mojom;

public final class Action {
  public static final int ANNOTATE_PAGE_IMAGES = 1;
  public static final int BLUR = 2;
  public static final int CLEAR_ACCESSIBILITY_FOCUS = 3;
  public static final int COLLAPSE = 4;
  public static final int CUSTOM_ACTION = 5;
  public static final int DECREMENT = 6;
  public static final int DEFAULT_VALUE = 0;
  public static final int DO_DEFAULT = 7;
  public static final int EXPAND = 8;
  public static final int FOCUS = 9;
  public static final int GET_IMAGE_DATA = 10;
  public static final int GET_TEXT_LOCATION = 11;
  public static final int HIDE_TOOLTIP = 12;
  public static final int HIT_TEST = 13;
  public static final int INCREMENT = 14;
  public static final int INTERNAL_INVALIDATE_TREE = 15;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int LOAD_INLINE_TEXT_BOXES = 16;
  public static final int LONG_CLICK = 38;
  public static final int MAX_VALUE = 40;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int REPLACE_SELECTED_TEXT = 17;
  public static final int RESUME_MEDIA = 34;
  public static final int SCROLL_BACKWARD = 18;
  public static final int SCROLL_DOWN = 19;
  public static final int SCROLL_FORWARD = 20;
  public static final int SCROLL_LEFT = 21;
  public static final int SCROLL_RIGHT = 22;
  public static final int SCROLL_TO_MAKE_VISIBLE = 24;
  public static final int SCROLL_TO_POINT = 25;
  public static final int SCROLL_TO_POSITION_AT_ROW_COLUMN = 39;
  public static final int SCROLL_UP = 23;
  public static final int SET_ACCESSIBILITY_FOCUS = 26;
  public static final int SET_SCROLL_OFFSET = 27;
  public static final int SET_SELECTION = 28;
  public static final int SET_SEQUENTIAL_FOCUS_NAVIGATION_STARTING_POINT = 29;
  public static final int SET_VALUE = 30;
  public static final int SHOW_CONTEXT_MENU = 31;
  public static final int SHOW_TOOLTIP = 33;
  public static final int SIGNAL_END_OF_TEST = 32;
  public static final int START_DUCKING_MEDIA = 35;
  public static final int STITCH_CHILD_TREE = 40;
  public static final int STOP_DUCKING_MEDIA = 36;
  public static final int SUSPEND_MEDIA = 37;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 40;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private Action() {}
}
