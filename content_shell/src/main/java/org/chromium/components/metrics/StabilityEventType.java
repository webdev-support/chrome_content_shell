package org.chromium.components.metrics;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface StabilityEventType {
  public static final int BROWSER_CRASH = 16;
  public static final int EXTENSION_CRASH = 5;
  public static final int EXTENSION_RENDERER_FAILED_LAUNCH = 25;
  public static final int EXTENSION_RENDERER_LAUNCH = 27;
  public static final int GPU_CRASH = 31;
  public static final int LAUNCH = 15;
  public static final int MAX_VALUE = 33;
  public static final int PAGE_LOAD = 2;
  public static final int RENDERER_CRASH = 3;
  public static final int RENDERER_FAILED_LAUNCH = 24;
  public static final int RENDERER_LAUNCH = 26;
  public static final int UTILITY_CRASH = 32;
  public static final int UTILITY_LAUNCH = 33;
}
