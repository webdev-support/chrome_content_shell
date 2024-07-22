package org.chromium.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface TraceRecordMode {
  public static final int ECHO_TO_CONSOLE = 3;
  public static final int RECORD_AS_MUCH_AS_POSSIBLE = 2;
  public static final int RECORD_CONTINUOUSLY = 1;
  public static final int RECORD_UNTIL_FULL = 0;
}
