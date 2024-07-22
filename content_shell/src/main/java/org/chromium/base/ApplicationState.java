package org.chromium.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ApplicationState {
  public static final int HAS_DESTROYED_ACTIVITIES = 4;
  public static final int HAS_PAUSED_ACTIVITIES = 2;
  public static final int HAS_RUNNING_ACTIVITIES = 1;
  public static final int HAS_STOPPED_ACTIVITIES = 3;
  public static final int UNKNOWN = 0;
}
