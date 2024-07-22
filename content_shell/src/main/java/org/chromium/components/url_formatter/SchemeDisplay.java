package org.chromium.components.url_formatter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface SchemeDisplay {
  public static final int OMIT_CRYPTOGRAPHIC = 2;
  public static final int OMIT_HTTP_AND_HTTPS = 1;
  public static final int SHOW = 0;
}
