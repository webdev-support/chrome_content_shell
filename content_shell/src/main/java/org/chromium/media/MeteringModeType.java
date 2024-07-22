package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface MeteringModeType {
  public static final int EXPOSURE = 1;
  public static final int FOCUS = 0;
  public static final int NUM_ENTRIES = 3;
  public static final int WHITE_BALANCE = 2;
}
