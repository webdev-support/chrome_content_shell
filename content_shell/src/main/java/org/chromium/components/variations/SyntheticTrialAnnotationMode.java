package org.chromium.components.variations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface SyntheticTrialAnnotationMode {
  public static final int CURRENT_LOG = 1;
  public static final int NEXT_LOG = 0;
}
