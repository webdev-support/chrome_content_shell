package org.chromium.components.location;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface LocationSettingsDialogOutcome {
  public static final int DENIED = 2;
  public static final int GRANTED = 1;
  public static final int NO_PROMPT = 3;
}
