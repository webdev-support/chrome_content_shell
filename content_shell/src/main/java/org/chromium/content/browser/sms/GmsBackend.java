package org.chromium.content.browser.sms;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface GmsBackend {
  public static final int AUTO = 0;
  public static final int USER_CONSENT = 1;
  public static final int VERIFICATION = 2;
}
