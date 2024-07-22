package org.chromium.content_public.browser;

import org.chromium.content.browser.ScreenOrientationProviderImpl;
import org.chromium.ui.base.WindowAndroid;

public interface ScreenOrientationProvider {
  void delayOrientationRequests(WindowAndroid windowAndroid);

  void lockOrientation(WindowAndroid windowAndroid, byte b);

  void runDelayedOrientationRequests(WindowAndroid windowAndroid);

  void setOrientationDelegate(ScreenOrientationDelegate screenOrientationDelegate);

  void setOverrideDefaultOrientation(WindowAndroid windowAndroid, byte b);

  void unlockOrientation(WindowAndroid windowAndroid);

  static ScreenOrientationProvider getInstance() {
    return ScreenOrientationProviderImpl.getInstance();
  }
}
