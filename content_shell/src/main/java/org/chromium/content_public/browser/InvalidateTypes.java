package org.chromium.content_public.browser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface InvalidateTypes {
  public static final int ALL = 31;
  public static final int AUDIO = 16;
  public static final int LOAD = 4;
  public static final int TAB = 2;
  public static final int TITLE = 8;
  public static final int URL = 1;
}
