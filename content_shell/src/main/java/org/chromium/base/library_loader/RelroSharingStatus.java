package org.chromium.base.library_loader;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface RelroSharingStatus {
  public static final int CORRUPTED_IN_JAVA = 7;
  public static final int COUNT = 9;
  public static final int EXTERNAL_LOAD_ADDRESS_RESET = 8;
  public static final int EXTERNAL_RELRO_FD_NOT_PROVIDED = 3;
  public static final int EXTERNAL_RELRO_NOT_FOUND = 4;
  public static final int NOT_ATTEMPTED = 0;
  public static final int NOT_IDENTICAL = 2;
  public static final int NO_SHMEM_FUNCTIONS = 5;
  public static final int REMAP_FAILED = 6;
  public static final int SHARED = 1;
}
