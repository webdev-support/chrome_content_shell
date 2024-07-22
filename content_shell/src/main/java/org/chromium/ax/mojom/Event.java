package org.chromium.ax.mojom;

public final class Event {
  public static final int ACTIVE_DESCENDANT_CHANGED = 1;
  public static final int ALERT = 2;
  public static final int ARIA_ATTRIBUTE_CHANGED_DEPRECATED = 3;
  public static final int AUTOCORRECTION_OCCURED = 4;
  public static final int BLUR = 5;
  public static final int CHECKED_STATE_CHANGED = 6;
  public static final int CHILDREN_CHANGED = 7;
  public static final int CLICKED = 8;
  public static final int CONTROLS_CHANGED = 9;
  public static final int DEFAULT_VALUE = 0;
  public static final int DOCUMENT_SELECTION_CHANGED = 10;
  public static final int DOCUMENT_TITLE_CHANGED = 11;
  public static final int END_OF_TEST = 12;
  public static final int EXPANDED_CHANGED = 13;
  public static final int FOCUS = 14;
  public static final int FOCUS_AFTER_MENU_CLOSE = 15;
  public static final int FOCUS_CONTEXT = 16;
  public static final int HIDE = 17;
  public static final int HIT_TEST_RESULT = 18;
  public static final int HOVER = 19;
  public static final int IMAGE_FRAME_UPDATED = 20;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int LAYOUT_COMPLETE = 21;
  public static final int LIVE_REGION_CHANGED = 23;
  public static final int LIVE_REGION_CREATED = 22;
  public static final int LOAD_COMPLETE = 24;
  public static final int LOAD_START = 25;
  public static final int LOCATION_CHANGED = 26;
  public static final int MAX_VALUE = 58;
  public static final int MEDIA_STARTED_PLAYING = 27;
  public static final int MEDIA_STOPPED_PLAYING = 28;
  public static final int MENU_END = 29;
  public static final int MENU_LIST_VALUE_CHANGED = 30;
  public static final int MENU_POPUP_END = 31;
  public static final int MENU_POPUP_START = 32;
  public static final int MENU_START = 33;
  public static final int MIN_VALUE = 0;
  public static final int MOUSE_CANCELED = 34;
  public static final int MOUSE_DRAGGED = 35;
  public static final int MOUSE_MOVED = 36;
  public static final int MOUSE_PRESSED = 37;
  public static final int MOUSE_RELEASED = 38;
  public static final int NONE = 0;
  public static final int ROW_COLLAPSED = 39;
  public static final int ROW_COUNT_CHANGED = 40;
  public static final int ROW_EXPANDED = 41;
  public static final int SCROLLED_TO_ANCHOR = 43;
  public static final int SCROLL_POSITION_CHANGED = 42;
  public static final int SELECTED_CHILDREN_CHANGED = 44;
  public static final int SELECTION = 45;
  public static final int SELECTION_ADD = 46;
  public static final int SELECTION_REMOVE = 47;
  public static final int SHOW = 48;
  public static final int STATE_CHANGED = 49;
  public static final int TEXT_CHANGED = 50;
  public static final int TEXT_SELECTION_CHANGED = 51;
  public static final int TOOLTIP_CLOSED = 52;
  public static final int TOOLTIP_OPENED = 53;
  public static final int TREE_CHANGED = 54;
  public static final int VALUE_CHANGED = 55;
  public static final int WINDOW_ACTIVATED = 56;
  public static final int WINDOW_DEACTIVATED = 57;
  public static final int WINDOW_VISIBILITY_CHANGED = 58;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 58;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private Event() {}
}
