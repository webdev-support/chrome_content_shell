package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface AndroidImageFormat {
  public static final int NV21 = 17;
  public static final int UNKNOWN = 0;
  public static final int YUV_420_888 = 35;
  public static final int YV12 = 842094169;
}
