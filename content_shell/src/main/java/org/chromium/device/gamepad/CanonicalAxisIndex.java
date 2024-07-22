package org.chromium.device.gamepad;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface CanonicalAxisIndex {
  public static final int COUNT = 4;
  public static final int LEFT_STICK_X = 0;
  public static final int LEFT_STICK_Y = 1;
  public static final int RIGHT_STICK_X = 2;
  public static final int RIGHT_STICK_Y = 3;
}
