package org.chromium.components.variations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface LoadSeedResult {
  public static final int CORRUPT_BASE64 = 4;
  public static final int CORRUPT_GZIP = 6;
  public static final int CORRUPT_PROTOBUF = 5;
  public static final int EMPTY = 1;
  public static final int INVALID_SIGNATURE = 3;
  public static final int LOAD_INTERRUPTED = 8;
  public static final int LOAD_OTHER_FAILURE = 9;
  public static final int LOAD_TIMED_OUT = 7;
  public static final int MAX_VALUE = 9;
  public static final int SUCCESS = 0;
}
