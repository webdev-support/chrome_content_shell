package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface MediaCodecDirection {
  public static final int DECODER = 0;
  public static final int ENCODER = 1;
}
