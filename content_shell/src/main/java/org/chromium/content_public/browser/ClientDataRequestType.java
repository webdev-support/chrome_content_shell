package org.chromium.content_public.browser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ClientDataRequestType {
  public static final int PAYMENT_GET = 2;
  public static final int WEB_AUTHN_CREATE = 0;
  public static final int WEB_AUTHN_GET = 1;
}
