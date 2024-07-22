package org.chromium.content_public.browser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface PermissionsPolicyFeature {
  public static final int PAYMENT = 8;
  public static final int WEB_SHARE = 78;
}
