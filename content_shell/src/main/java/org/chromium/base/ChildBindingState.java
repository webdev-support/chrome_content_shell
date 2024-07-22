package org.chromium.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ChildBindingState {
  public static final int MAX_VALUE = 4;
  public static final int NOT_PERCEPTIBLE = 2;
  public static final int STRONG = 4;
  public static final int UNBOUND = 0;
  public static final int VISIBLE = 3;
  public static final int WAIVED = 1;
}
