package org.chromium.ui.permissions;

public abstract class ContextualNotificationPermissionRequester {
  private static ContextualNotificationPermissionRequester sInstance;

  public abstract boolean doesAppLevelSettingsAllowSiteNotifications();

  public abstract void requestPermissionIfNeeded();

  public static ContextualNotificationPermissionRequester getInstance() {
    return sInstance;
  }

  public static void setInstance(ContextualNotificationPermissionRequester instance) {
    sInstance = instance;
  }
}
