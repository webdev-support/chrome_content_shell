package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface MediaContainerName {
  public static final int CONTAINER_AAC = 1;
  public static final int CONTAINER_AC3 = 2;
  public static final int CONTAINER_AIFF = 3;
  public static final int CONTAINER_AMR = 4;
  public static final int CONTAINER_APE = 5;
  public static final int CONTAINER_ASF = 6;
  public static final int CONTAINER_ASS = 7;
  public static final int CONTAINER_AVI = 8;
  public static final int CONTAINER_BINK = 9;
  public static final int CONTAINER_CAF = 10;
  public static final int CONTAINER_DASH = 38;
  public static final int CONTAINER_DTS = 11;
  public static final int CONTAINER_DTSHD = 12;
  public static final int CONTAINER_DV = 13;
  public static final int CONTAINER_DXA = 14;
  public static final int CONTAINER_EAC3 = 15;
  public static final int CONTAINER_FLAC = 16;
  public static final int CONTAINER_FLV = 17;
  public static final int CONTAINER_GSM = 18;
  public static final int CONTAINER_H261 = 19;
  public static final int CONTAINER_H263 = 20;
  public static final int CONTAINER_H264 = 21;
  public static final int CONTAINER_HLS = 22;
  public static final int CONTAINER_IRCAM = 23;
  public static final int CONTAINER_MJPEG = 24;
  public static final int CONTAINER_MOV = 25;
  public static final int CONTAINER_MP3 = 26;
  public static final int CONTAINER_MPEG2PS = 27;
  public static final int CONTAINER_MPEG2TS = 28;
  public static final int CONTAINER_MPEG4BS = 29;
  public static final int CONTAINER_OGG = 30;
  public static final int CONTAINER_RM = 31;
  public static final int CONTAINER_SMOOTH_STREAM = 39;
  public static final int CONTAINER_SRT = 32;
  public static final int CONTAINER_SWF = 33;
  public static final int CONTAINER_UNKNOWN = 0;
  public static final int CONTAINER_VC1 = 34;
  public static final int CONTAINER_WAV = 35;
  public static final int CONTAINER_WEBM = 36;
  public static final int CONTAINER_WTV = 37;
  public static final int MAX_VALUE = 39;
}
