package org.chromium.ui.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface PointerType {
  public static final int COARSE = 2;
  public static final int FINE = 4;
  public static final int FIRST = 1;
  public static final int LAST = 4;
  public static final int NONE = 1;
}
