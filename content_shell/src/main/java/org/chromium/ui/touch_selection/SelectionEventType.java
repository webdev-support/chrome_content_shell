package org.chromium.ui.touch_selection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface SelectionEventType {
  public static final int INSERTION_HANDLE_CLEARED = 8;
  public static final int INSERTION_HANDLE_DRAG_STARTED = 9;
  public static final int INSERTION_HANDLE_DRAG_STOPPED = 10;
  public static final int INSERTION_HANDLE_MOVED = 6;
  public static final int INSERTION_HANDLE_SHOWN = 5;
  public static final int INSERTION_HANDLE_TAPPED = 7;
  public static final int SELECTION_HANDLES_CLEARED = 2;
  public static final int SELECTION_HANDLES_MOVED = 1;
  public static final int SELECTION_HANDLES_SHOWN = 0;
  public static final int SELECTION_HANDLE_DRAG_STARTED = 3;
  public static final int SELECTION_HANDLE_DRAG_STOPPED = 4;
}
