package org.chromium.components.location;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface LocationSettingsDialogContext {
  public static final int DEFAULT = 1;
  public static final int SEARCH = 2;
}
