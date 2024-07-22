package org.chromium.ui.touch_selection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface TouchSelectionDraggableType {
  public static final int LONGPRESS = 2;
  public static final int NONE = 0;
  public static final int TOUCH_HANDLE = 1;
}
