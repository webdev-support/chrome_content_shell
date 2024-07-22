package org.chromium.content.browser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface MotionEventAction {
  public static final int CANCEL = 2;
  public static final int END = 3;
  public static final int HOVER_ENTER = 5;
  public static final int HOVER_EXIT = 6;
  public static final int HOVER_MOVE = 7;
  public static final int INVALID = -1;
  public static final int MOVE = 1;
  public static final int SCROLL = 4;
  public static final int START = 0;
}
