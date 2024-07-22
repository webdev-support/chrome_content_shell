package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface PhotoCapabilityInt {
  public static final int CURRENT_COLOR_TEMPERATURE = 14;
  public static final int CURRENT_HEIGHT = 6;
  public static final int CURRENT_ISO = 2;
  public static final int CURRENT_WIDTH = 10;
  public static final int MAX_COLOR_TEMPERATURE = 13;
  public static final int MAX_HEIGHT = 5;
  public static final int MAX_ISO = 1;
  public static final int MAX_WIDTH = 9;
  public static final int MIN_COLOR_TEMPERATURE = 12;
  public static final int MIN_HEIGHT = 4;
  public static final int MIN_ISO = 0;
  public static final int MIN_WIDTH = 8;
  public static final int NUM_ENTRIES = 16;
  public static final int STEP_COLOR_TEMPERATURE = 15;
  public static final int STEP_HEIGHT = 7;
  public static final int STEP_ISO = 3;
  public static final int STEP_WIDTH = 11;
}
