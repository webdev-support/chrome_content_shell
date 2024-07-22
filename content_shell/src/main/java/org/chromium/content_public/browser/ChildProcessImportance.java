package org.chromium.content_public.browser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ChildProcessImportance {
  public static final int IMPORTANT = 2;
  public static final int MODERATE = 1;
  public static final int NORMAL = 0;
}
