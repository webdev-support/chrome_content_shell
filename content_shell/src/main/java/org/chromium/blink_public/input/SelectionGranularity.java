package org.chromium.blink_public.input;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface SelectionGranularity {
  public static final int SENTENCE = 1;
  public static final int WORD = 0;
}
