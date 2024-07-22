package org.chromium.components.crash;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface CrashKeyIndex {
  public static final int ACTIVE_DYNAMIC_MODULE = 1;
  public static final int APPLICATION_STATUS = 2;
  public static final int DYNAMIC_MODULE_DEX_NAME = 5;
  public static final int EMULATED_MODULES = 4;
  public static final int FIRST_RUN = 7;
  public static final int INSTALLED_MODULES = 3;
  public static final int LOADED_DYNAMIC_MODULE = 0;
  public static final int NUM_ENTRIES = 8;
  public static final int PARTNER_CUSTOMIZATION_CONFIG = 6;
}
