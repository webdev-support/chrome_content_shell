package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface AudioEncodingFormat {
  public static final int BITSTREAM_AC3 = 4;
  public static final int BITSTREAM_DTS = 16;
  public static final int BITSTREAM_DTSX_P2 = 64;
  public static final int BITSTREAM_DTS_HD = 32;
  public static final int BITSTREAM_DTS_HD_MA = 256;
  public static final int BITSTREAM_EAC3 = 8;
  public static final int BITSTREAM_IEC61937 = 128;
  public static final int FAKE = 0;
  public static final int FORMAT_LAST = 256;
  public static final int PCM_LINEAR = 1;
  public static final int PCM_LOW_LATENCY = 2;
}
