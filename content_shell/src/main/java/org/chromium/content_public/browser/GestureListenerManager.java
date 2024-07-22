package org.chromium.content_public.browser;

import org.chromium.content.browser.GestureListenerManagerImpl;

public interface GestureListenerManager {
  void addListener(GestureStateListener gestureStateListener);

  void addListener(GestureStateListener gestureStateListener, int i);

  boolean hasListener(GestureStateListener gestureStateListener);

  boolean isScrollInProgress();

  void removeListener(GestureStateListener gestureStateListener);

  void updateDoubleTapSupport(boolean z);

  void updateMultiTouchZoomSupport(boolean z);

  static GestureListenerManager fromWebContents(WebContents webContents) {
    return GestureListenerManagerImpl.fromWebContents(webContents);
  }
}
