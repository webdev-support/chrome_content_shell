package org.chromium.content_public.browser;

public interface NavigationController {
  boolean canGoBack();

  boolean canGoForward();

  boolean canGoToOffset(int i);

  void cancelPendingReload();

  void clearHistory();

  void clearSslPreferences();

  void continuePendingReload();

  NavigationHistory getDirectedNavigationHistory(boolean z, int i);

  NavigationEntry getEntryAtIndex(int i);

  String getEntryExtraData(int i, String str);

  int getLastCommittedEntryIndex();

  NavigationHistory getNavigationHistory();

  NavigationEntry getPendingEntry();

  boolean getUseDesktopUserAgent();

  NavigationEntry getVisibleEntry();

  void goBack();

  void goForward();

  void goToNavigationIndex(int i);

  void goToOffset(int i);

  boolean isInitialNavigation();

  void loadIfNecessary();

  NavigationHandle loadUrl(LoadUrlParams loadUrlParams);

  boolean needsReload();

  void pruneForwardEntries();

  void reload(boolean z);

  void reloadBypassingCache(boolean z);

  boolean removeEntryAtIndex(int i);

  void setEntryExtraData(int i, String str, String str2);

  void setNeedsReload();

  void setUseDesktopUserAgent(boolean z, boolean z2, int i);
}
