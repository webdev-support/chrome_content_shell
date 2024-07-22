package org.chromium.content_public.browser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface MessagePayloadType {
  public static final int ARRAY_BUFFER = 1;
  public static final int INVALID = -1;
  public static final int STRING = 0;
}
