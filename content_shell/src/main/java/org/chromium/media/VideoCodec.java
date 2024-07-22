package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface VideoCodec {
  public static final int AV1 = 10;
  public static final int DOLBY_VISION = 9;
  public static final int H264 = 1;
  public static final int HEVC = 8;
  public static final int MAX_VALUE = 10;
  public static final int MPEG2 = 3;
  public static final int MPEG4 = 4;
  public static final int THEORA = 5;
  public static final int UNKNOWN = 0;
  public static final int VC1 = 2;
  public static final int VP8 = 6;
  public static final int VP9 = 7;
}
