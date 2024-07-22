package org.chromium.ui.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface BackGestureEventSwipeEdge {
  public static final int LEFT = 0;
  public static final int RIGHT = 1;
}
