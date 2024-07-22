package org.chromium.base.library_loader;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface LoaderErrors {
  public static final int FAILED_TO_REGISTER_JNI = 1;
  public static final int NATIVE_LIBRARY_LOAD_FAILED = 2;
  public static final int NATIVE_LIBRARY_WRONG_VERSION = 3;
  public static final int NATIVE_STARTUP_FAILED = 4;
  public static final int NORMAL_COMPLETION = 0;
}
