package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface AndroidFillLightMode {
  public static final int AUTO = 2;
  public static final int FLASH = 3;
  public static final int NOT_SET = 0;
  public static final int NUM_ENTRIES = 4;
  public static final int OFF = 1;
}
