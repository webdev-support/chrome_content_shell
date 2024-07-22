package org.chromium.color.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class RendererColorId {
  public static final int COLOR_MENU_BACKGROUND = 0;
  public static final int COLOR_MENU_ITEM_BACKGROUND_SELECTED = 1;
  public static final int COLOR_MENU_SEPARATOR = 2;
  public static final int COLOR_OVERLAY_SCROLLBAR_FILL = 3;
  public static final int COLOR_OVERLAY_SCROLLBAR_FILL_DARK = 4;
  public static final int COLOR_OVERLAY_SCROLLBAR_FILL_HOVERED = 6;
  public static final int COLOR_OVERLAY_SCROLLBAR_FILL_HOVERED_DARK = 7;
  public static final int COLOR_OVERLAY_SCROLLBAR_FILL_HOVERED_LIGHT = 8;
  public static final int COLOR_OVERLAY_SCROLLBAR_FILL_LIGHT = 5;
  public static final int COLOR_OVERLAY_SCROLLBAR_STROKE = 9;
  public static final int COLOR_OVERLAY_SCROLLBAR_STROKE_DARK = 10;
  public static final int COLOR_OVERLAY_SCROLLBAR_STROKE_HOVERED = 12;
  public static final int COLOR_OVERLAY_SCROLLBAR_STROKE_HOVERED_DARK = 13;
  public static final int COLOR_OVERLAY_SCROLLBAR_STROKE_HOVERED_LIGHT = 14;
  public static final int COLOR_OVERLAY_SCROLLBAR_STROKE_LIGHT = 11;
  public static final int COLOR_WEB_NATIVE_CONTROL_ACCENT = 15;
  public static final int COLOR_WEB_NATIVE_CONTROL_ACCENT_DISABLED = 16;
  public static final int COLOR_WEB_NATIVE_CONTROL_ACCENT_HOVERED = 17;
  public static final int COLOR_WEB_NATIVE_CONTROL_ACCENT_PRESSED = 18;
  public static final int COLOR_WEB_NATIVE_CONTROL_AUTO_COMPLETE_BACKGROUND = 19;
  public static final int COLOR_WEB_NATIVE_CONTROL_BACKGROUND = 20;
  public static final int COLOR_WEB_NATIVE_CONTROL_BACKGROUND_DISABLED = 21;
  public static final int COLOR_WEB_NATIVE_CONTROL_BORDER = 22;
  public static final int COLOR_WEB_NATIVE_CONTROL_BORDER_DISABLED = 23;
  public static final int COLOR_WEB_NATIVE_CONTROL_BORDER_HOVERED = 24;
  public static final int COLOR_WEB_NATIVE_CONTROL_BORDER_PRESSED = 25;
  public static final int COLOR_WEB_NATIVE_CONTROL_BUTTON_BORDER = 26;
  public static final int COLOR_WEB_NATIVE_CONTROL_BUTTON_BORDER_DISABLED = 27;
  public static final int COLOR_WEB_NATIVE_CONTROL_BUTTON_BORDER_HOVERED = 28;
  public static final int COLOR_WEB_NATIVE_CONTROL_BUTTON_BORDER_PRESSED = 29;
  public static final int COLOR_WEB_NATIVE_CONTROL_BUTTON_FILL = 30;
  public static final int COLOR_WEB_NATIVE_CONTROL_BUTTON_FILL_DISABLED = 31;
  public static final int COLOR_WEB_NATIVE_CONTROL_BUTTON_FILL_HOVERED = 32;
  public static final int COLOR_WEB_NATIVE_CONTROL_BUTTON_FILL_PRESSED = 33;
  public static final int COLOR_WEB_NATIVE_CONTROL_FILL = 34;
  public static final int COLOR_WEB_NATIVE_CONTROL_FILL_DISABLED = 35;
  public static final int COLOR_WEB_NATIVE_CONTROL_FILL_HOVERED = 36;
  public static final int COLOR_WEB_NATIVE_CONTROL_FILL_PRESSED = 37;
  public static final int COLOR_WEB_NATIVE_CONTROL_LIGHTEN_LAYER = 38;
  public static final int COLOR_WEB_NATIVE_CONTROL_PROGRESS_VALUE = 39;
  public static final int COLOR_WEB_NATIVE_CONTROL_SCROLLBAR_ARROW_BACKGROUND_HOVERED = 40;
  public static final int COLOR_WEB_NATIVE_CONTROL_SCROLLBAR_ARROW_BACKGROUND_PRESSED = 41;
  public static final int COLOR_WEB_NATIVE_CONTROL_SCROLLBAR_ARROW_FOREGROUND = 42;
  public static final int COLOR_WEB_NATIVE_CONTROL_SCROLLBAR_ARROW_FOREGROUND_PRESSED = 43;
  public static final int COLOR_WEB_NATIVE_CONTROL_SCROLLBAR_CORNER = 44;
  public static final int COLOR_WEB_NATIVE_CONTROL_SCROLLBAR_THUMB = 45;
  public static final int COLOR_WEB_NATIVE_CONTROL_SCROLLBAR_THUMB_HOVERED = 46;
  public static final int COLOR_WEB_NATIVE_CONTROL_SCROLLBAR_THUMB_INACTIVE = 47;
  public static final int COLOR_WEB_NATIVE_CONTROL_SCROLLBAR_THUMB_OVERLAY_MINIMAL_MODE = 48;
  public static final int COLOR_WEB_NATIVE_CONTROL_SCROLLBAR_THUMB_PRESSED = 49;
  public static final int COLOR_WEB_NATIVE_CONTROL_SCROLLBAR_TRACK = 50;
  public static final int COLOR_WEB_NATIVE_CONTROL_SLIDER = 51;
  public static final int COLOR_WEB_NATIVE_CONTROL_SLIDER_DISABLED = 52;
  public static final int COLOR_WEB_NATIVE_CONTROL_SLIDER_HOVERED = 53;
  public static final int COLOR_WEB_NATIVE_CONTROL_SLIDER_PRESSED = 54;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 54;
  public static final int MIN_VALUE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 54;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private RendererColorId() {}
}
