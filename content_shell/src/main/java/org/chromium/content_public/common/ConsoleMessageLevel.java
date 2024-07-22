package org.chromium.content_public.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ConsoleMessageLevel {
  public static final int ERROR = 3;
  public static final int INFO = 1;
  public static final int LAST = 3;
  public static final int VERBOSE = 0;
  public static final int WARNING = 2;
}
