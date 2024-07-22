package org.chromium.base.task;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface TaskTraits {
  public static final int BEST_EFFORT = 0;
  public static final int BEST_EFFORT_MAY_BLOCK = 1;
  public static final int THREAD_POOL_TRAITS_END = 5;
  public static final int THREAD_POOL_TRAITS_START = 0;
  public static final int UI_BEST_EFFORT = 6;
  public static final int UI_DEFAULT = 7;
  public static final int UI_TRAITS_END = 8;
  public static final int UI_TRAITS_START = 6;
  public static final int UI_USER_BLOCKING = 8;
  public static final int UI_USER_VISIBLE = 7;
  public static final int USER_BLOCKING = 4;
  public static final int USER_BLOCKING_MAY_BLOCK = 5;
  public static final int USER_VISIBLE = 2;
  public static final int USER_VISIBLE_MAY_BLOCK = 3;
}
