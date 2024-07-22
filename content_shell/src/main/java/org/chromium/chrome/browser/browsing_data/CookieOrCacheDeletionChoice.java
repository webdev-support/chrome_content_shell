package org.chromium.chrome.browser.browsing_data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface CookieOrCacheDeletionChoice {
  public static final int BOTH_COOKIES_AND_CACHE = 3;
  public static final int MAX_CHOICE_VALUE = 4;
  public static final int NEITHER_COOKIES_NOR_CACHE = 0;
  public static final int ONLY_CACHE = 2;
  public static final int ONLY_COOKIES = 1;
}
