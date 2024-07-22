package org.chromium.content_public.browser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface Visibility {
  public static final int HIDDEN = 0;
  public static final int OCCLUDED = 1;
  public static final int VISIBLE = 2;
}
