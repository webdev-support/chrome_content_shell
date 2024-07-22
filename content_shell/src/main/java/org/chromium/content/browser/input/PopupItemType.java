package org.chromium.content.browser.input;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface PopupItemType {
  public static final int DISABLED = 1;
  public static final int ENABLED = 2;
  public static final int GROUP = 0;
}
