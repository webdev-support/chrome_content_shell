package org.chromium.ui;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface OverscrollAction {
  public static final int HISTORY_NAVIGATION = 2;
  public static final int NONE = 0;
  public static final int PULL_TO_REFRESH = 1;
}
