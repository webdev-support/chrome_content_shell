package org.chromium.ui.gfx;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface OverlayTransform {
  public static final int FLIP_HORIZONTAL = 2;
  public static final int FLIP_VERTICAL = 3;
  public static final int INVALID = 0;
  public static final int LAST = 6;
  public static final int NONE = 1;
  public static final int ROTATE_CLOCKWISE_180 = 5;
  public static final int ROTATE_CLOCKWISE_270 = 6;
  public static final int ROTATE_CLOCKWISE_90 = 4;
}
