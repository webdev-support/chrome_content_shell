package org.chromium.content_public.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface IsolatedWorldIds {
  public static final int ISOLATED_WORLD_ID_CONTENT_END = 1;
  public static final int ISOLATED_WORLD_ID_GLOBAL = 0;
  public static final int ISOLATED_WORLD_ID_MAX = 11;
}
