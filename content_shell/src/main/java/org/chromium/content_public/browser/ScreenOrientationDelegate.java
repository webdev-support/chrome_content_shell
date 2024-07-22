package org.chromium.content_public.browser;

import android.app.Activity;

public interface ScreenOrientationDelegate {
  boolean canLockOrientation();

  boolean canUnlockOrientation(Activity activity, int i);
}
