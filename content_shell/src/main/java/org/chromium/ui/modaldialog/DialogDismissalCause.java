package org.chromium.ui.modaldialog;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface DialogDismissalCause {
  public static final int ACTION_ON_CONTENT = 3;
  public static final int ACTION_ON_DIALOG_COMPLETED = 13;
  public static final int ACTION_ON_DIALOG_NOT_POSSIBLE = 14;
  public static final int ACTIVITY_DESTROYED = 8;
  public static final int CLIENT_TIMEOUT = 15;
  public static final int DIALOG_INTERACTION_DEFERRED = 12;
  public static final int DISMISSED_BY_NATIVE = 4;
  public static final int NAVIGATE = 10;
  public static final int NAVIGATE_BACK_OR_TOUCH_OUTSIDE = 5;
  public static final int NEGATIVE_BUTTON_CLICKED = 2;
  public static final int NOT_ATTACHED_TO_WINDOW = 9;
  public static final int POSITIVE_BUTTON_CLICKED = 1;
  public static final int TAB_DESTROYED = 7;
  public static final int TAB_SWITCHED = 6;
  public static final int UNKNOWN = 0;
  public static final int WEB_CONTENTS_DESTROYED = 11;
}
