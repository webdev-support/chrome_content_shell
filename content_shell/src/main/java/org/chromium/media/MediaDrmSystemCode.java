package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface MediaDrmSystemCode {
  public static final int CREATE_SESSION_FAILED = 1100004;
  public static final int DENIED_BY_SERVER = 1100012;
  public static final int GET_KEY_RELEASE_REQUEST_FAILED = 1100011;
  public static final int GET_KEY_REQUEST_FAILED = 1100009;
  public static final int ILLEGAL_STATE = 1100013;
  public static final int INVALID_SESSION_ID = 1100002;
  public static final int KEY_UPDATE_FAILED = 1100010;
  public static final int MAX_VALUE = 1100013;
  public static final int MIN_VALUE = 1100000;
  public static final int NOT_PERSISTENT_LICENSE = 1100007;
  public static final int NOT_PROVISIONED = 1100003;
  public static final int NO_MEDIA_DRM = 1100001;
  public static final int OPEN_SESSION_FAILED = 1100005;
  public static final int SET_KEY_TYPE_RELEASE_FAILED = 1100008;
  public static final int SET_SERVER_CERTIFICATE_FAILED = 1100000;
  public static final int UPDATE_FAILED = 1100006;
}
