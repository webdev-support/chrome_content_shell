package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class EventType {
  public static final int CHAR = 10;
  public static final int CONTEXT_MENU = 5;
  public static final int GESTURE_DOUBLE_TAP = 28;
  public static final int GESTURE_FLING_CANCEL = 15;
  public static final int GESTURE_FLING_START = 14;
  public static final int GESTURE_LONG_PRESS = 24;
  public static final int GESTURE_LONG_TAP = 25;
  public static final int GESTURE_PINCH_BEGIN = 16;
  public static final int GESTURE_PINCH_END = 17;
  public static final int GESTURE_PINCH_TYPE_FIRST = 16;
  public static final int GESTURE_PINCH_TYPE_LAST = 18;
  public static final int GESTURE_PINCH_UPDATE = 18;
  public static final int GESTURE_SCROLL_BEGIN = 11;
  public static final int GESTURE_SCROLL_END = 12;
  public static final int GESTURE_SCROLL_UPDATE = 13;
  public static final int GESTURE_SHORT_PRESS = 23;
  public static final int GESTURE_SHOW_PRESS = 20;
  public static final int GESTURE_TAP = 21;
  public static final int GESTURE_TAP_CANCEL = 22;
  public static final int GESTURE_TAP_DOWN = 19;
  public static final int GESTURE_TAP_UNCONFIRMED = 27;
  public static final int GESTURE_TWO_FINGER_TAP = 26;
  public static final int GESTURE_TYPE_FIRST = 11;
  public static final int GESTURE_TYPE_LAST = 28;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int KEYBOARD_TYPE_FIRST = 7;
  public static final int KEYBOARD_TYPE_LAST = 10;
  public static final int KEY_DOWN = 8;
  public static final int KEY_UP = 9;
  public static final int MAX_VALUE = 39;
  public static final int MIN_VALUE = -1;
  public static final int MOUSE_DOWN = 0;
  public static final int MOUSE_ENTER = 3;
  public static final int MOUSE_LEAVE = 4;
  public static final int MOUSE_MOVE = 2;
  public static final int MOUSE_TYPE_FIRST = 0;
  public static final int MOUSE_TYPE_LAST = 5;
  public static final int MOUSE_UP = 1;
  public static final int MOUSE_WHEEL = 6;
  public static final int POINTER_CANCEL = 38;
  public static final int POINTER_CAUSED_UA_ACTION = 39;
  public static final int POINTER_DOWN = 34;
  public static final int POINTER_MOVE = 36;
  public static final int POINTER_RAW_UPDATE = 37;
  public static final int POINTER_TYPE_FIRST = 34;
  public static final int POINTER_TYPE_LAST = 39;
  public static final int POINTER_UP = 35;
  public static final int RAW_KEY_DOWN = 7;
  public static final int TOUCH_CANCEL = 32;
  public static final int TOUCH_END = 31;
  public static final int TOUCH_MOVE = 30;
  public static final int TOUCH_SCROLL_STARTED = 33;
  public static final int TOUCH_START = 29;
  public static final int TOUCH_TYPE_FIRST = 29;
  public static final int TOUCH_TYPE_LAST = 33;
  public static final int TYPE_FIRST = -1;
  public static final int TYPE_LAST = 39;
  public static final int UNDEFINED = -1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= -1 && value <= 39;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private EventType() {}
}
