package org.chromium.ui.gfx;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface BitmapFormat {
  public static final int ALPHA_8 = 8;
  public static final int ARGB_4444 = 7;
  public static final int ARGB_8888 = 1;
  public static final int NO_CONFIG = 0;
  public static final int RGB_565 = 4;
}
