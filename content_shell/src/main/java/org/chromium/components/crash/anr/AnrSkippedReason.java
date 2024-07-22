package org.chromium.components.crash.anr;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface AnrSkippedReason {
  public static final int FILESYSTEM_READ_FAILURE = 0;
  public static final int FILESYSTEM_WRITE_FAILURE = 1;
  public static final int MAX_VALUE = 4;
  public static final int MISSING_VERSION = 2;
  public static final int NOT_SKIPPED = 4;
  public static final int ONLY_MISSING_NATIVE = 3;
}
