package org.chromium.net;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface TrafficStatsError {
  public static final int ERROR_NOT_SUPPORTED = 0;
}
