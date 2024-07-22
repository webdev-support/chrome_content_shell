package org.chromium.content_public.browser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface LifecycleState {
  public static final int ACTIVE = 1;
  public static final int IN_BACK_FORWARD_CACHE = 3;
  public static final int PENDING_COMMIT = 0;
  public static final int PENDING_DELETION = 4;
  public static final int PRERENDERING = 2;
}
