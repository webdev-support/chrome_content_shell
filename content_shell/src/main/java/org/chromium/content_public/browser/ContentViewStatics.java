package org.chromium.content_public.browser;

import org.chromium.content.browser.ContentViewStaticsImpl;

public class ContentViewStatics {
  public static void setWebKitSharedTimersSuspended(boolean suspend) {
    ContentViewStaticsImpl.setWebKitSharedTimersSuspended(suspend);
  }

  public static void enablePlatformNotifications() {
    ContentViewStaticsImpl.enablePlatformNotifications();
  }

  public static void disablePlatformNotifications() {
    ContentViewStaticsImpl.disablePlatformNotifications();
  }
}
