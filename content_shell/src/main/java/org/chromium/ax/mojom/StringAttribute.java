package org.chromium.ax.mojom;

public final class StringAttribute {
  public static final int ACCESS_KEY = 1;
  public static final int APP_ID = 2;
  public static final int ARIA_BRAILLE_LABEL = 33;
  public static final int ARIA_BRAILLE_ROLE_DESCRIPTION = 34;
  public static final int ARIA_INVALID_VALUE_DEPRECATED = 3;
  public static final int AUTO_COMPLETE = 4;
  public static final int CHECKED_STATE_DESCRIPTION = 5;
  public static final int CHILD_TREE_ID = 6;
  public static final int CHILD_TREE_NODE_APP_ID = 7;
  public static final int CLASS_NAME = 8;
  public static final int CONTAINER_LIVE_RELEVANT = 9;
  public static final int CONTAINER_LIVE_STATUS = 10;
  public static final int DEFAULT_VALUE = 0;
  public static final int DESCRIPTION = 11;
  public static final int DISPLAY = 12;
  public static final int DO_DEFAULT_LABEL = 31;
  public static final int FONT_FAMILY = 13;
  public static final int HTML_TAG = 14;
  public static final int IMAGE_ANNOTATION = 15;
  public static final int IMAGE_DATA_URL = 16;
  public static final int INNER_HTML = 17;
  public static final int INPUT_TYPE = 18;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int KEY_SHORTCUTS = 19;
  public static final int LANGUAGE = 20;
  public static final int LINK_TARGET = 35;
  public static final int LIVE_RELEVANT = 22;
  public static final int LIVE_STATUS = 23;
  public static final int LONG_CLICK_LABEL = 32;
  public static final int MAX_VALUE = 35;
  public static final int MIN_VALUE = 0;
  public static final int NAME = 21;
  public static final int NONE = 0;
  public static final int PLACEHOLDER = 24;
  public static final int ROLE = 25;
  public static final int ROLE_DESCRIPTION = 26;
  public static final int TOOLTIP = 27;
  public static final int URL = 28;
  public static final int VALUE = 29;
  public static final int VIRTUAL_CONTENT = 30;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 35;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private StringAttribute() {}
}
