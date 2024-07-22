package org.chromium.ui.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class EventType {
  public static final int CANCEL_MODE = 11;
  public static final int GESTURE_PINCH_BEGIN = 5;
  public static final int GESTURE_PINCH_END = 6;
  public static final int GESTURE_PINCH_UPDATE = 7;
  public static final int GESTURE_SWIPE = 4;
  public static final int GESTURE_TAP = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int KEY_PRESSED = 1;
  public static final int KEY_RELEASED = 2;
  public static final int MAX_VALUE = 23;
  public static final int MIN_VALUE = 0;
  public static final int MOUSE_CAPTURE_CHANGED_EVENT = 19;
  public static final int MOUSE_DRAGGED_EVENT = 13;
  public static final int MOUSE_ENTERED_EVENT = 16;
  public static final int MOUSE_EXITED_EVENT = 17;
  public static final int MOUSE_MOVED_EVENT = 15;
  public static final int MOUSE_PRESSED_EVENT = 12;
  public static final int MOUSE_RELEASED_EVENT = 14;
  public static final int MOUSE_WHEEL_EVENT = 18;
  public static final int SCROLL = 8;
  public static final int SCROLL_FLING_CANCEL = 10;
  public static final int SCROLL_FLING_START = 9;
  public static final int TOUCH_CANCELLED = 23;
  public static final int TOUCH_MOVED = 22;
  public static final int TOUCH_PRESSED = 21;
  public static final int TOUCH_RELEASED = 20;
  public static final int UNKNOWN = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 23;
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
