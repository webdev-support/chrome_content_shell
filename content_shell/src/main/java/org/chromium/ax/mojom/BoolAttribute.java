package org.chromium.ax.mojom;

public final class BoolAttribute {
  public static final int BUSY = 1;
  public static final int CANVAS_HAS_FALLBACK = 8;
  public static final int CLICKABLE = 10;
  public static final int CLIPS_CHILDREN = 11;
  public static final int CONTAINER_LIVE_ATOMIC = 3;
  public static final int CONTAINER_LIVE_BUSY = 4;
  public static final int DEFAULT_VALUE = 0;
  public static final int GRABBED_DEPRECATED = 16;
  public static final int HAS_ARIA_ATTRIBUTE = 19;
  public static final int HAS_HIDDEN_OFFSCREEN_NODES = 22;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int IS_LINE_BREAKING_OBJECT = 17;
  public static final int IS_PAGE_BREAKING_OBJECT = 18;
  public static final int LIVE_ATOMIC = 5;
  public static final int LONG_CLICKABLE = 21;
  public static final int MAX_VALUE = 22;
  public static final int MIN_VALUE = 0;
  public static final int MODAL = 6;
  public static final int NONE = 0;
  public static final int NON_ATOMIC_TEXT_FIELD_ROOT = 2;
  public static final int NOT_USER_SELECTABLE_STYLE = 12;
  public static final int SCROLLABLE = 9;
  public static final int SELECTED = 13;
  public static final int SELECTED_FROM_FOCUS = 14;
  public static final int SUPPORTS_TEXT_LOCATION = 15;
  public static final int TOUCH_PASSTHROUGH_DEPRECATED = 20;
  public static final int UPDATE_LOCATION_ONLY = 7;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 22;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private BoolAttribute() {}
}
