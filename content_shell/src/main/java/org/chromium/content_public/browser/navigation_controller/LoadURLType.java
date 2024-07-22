package org.chromium.content_public.browser.navigation_controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface LoadURLType {
  public static final int DATA = 2;
  public static final int DEFAULT = 0;
  public static final int HTTP_POST = 1;
}
