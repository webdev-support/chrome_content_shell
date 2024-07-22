package org.chromium.content_public.browser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.chromium.base.metrics.RecordHistogram;

public class KeyboardShortcutRecorder {

  @Retention(RetentionPolicy.SOURCE)
  public @interface KeyboardShortcut {
    public static final int COUNT = 6;
    public static final int DELETE_LINE = 3;
    public static final int PAGE_DOWN = 5;
    public static final int PAGE_UP = 4;
    public static final int ZOOM_IN = 0;
    public static final int ZOOM_OUT = 1;
    public static final int ZOOM_RESET = 2;
  }

  private KeyboardShortcutRecorder() {}

  public static void recordKeyboardShortcut(int keyboardShortcut) {
    RecordHistogram.recordEnumeratedHistogram(
        "InputMethod.PhysicalKeyboard.KeyboardShortcut", keyboardShortcut, 6);
  }
}
