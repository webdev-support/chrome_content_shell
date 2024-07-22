package org.chromium.base.task;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface TaskRunnerType {
  public static final int BASE = 0;
  public static final int SEQUENCED = 1;
  public static final int SINGLE_THREAD = 2;
}
