package org.chromium.ui.touch_selection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface TouchHandleOrientation {
  public static final int CENTER = 1;
  public static final int LEFT = 0;
  public static final int RIGHT = 2;
  public static final int UNDEFINED = 3;
}
