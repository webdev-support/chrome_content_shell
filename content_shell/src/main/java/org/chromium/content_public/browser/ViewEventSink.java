package org.chromium.content_public.browser;

import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.MotionEvent;
import org.chromium.content.browser.ViewEventSinkImpl;

public interface ViewEventSink {

  public interface InternalAccessDelegate {
    void onScrollChanged(int i, int i2, int i3, int i4);

    boolean super_dispatchKeyEvent(KeyEvent keyEvent);

    boolean super_onGenericMotionEvent(MotionEvent motionEvent);

    boolean super_onKeyUp(int i, KeyEvent keyEvent);
  }

  void onAttachedToWindow();

  void onConfigurationChanged(Configuration configuration);

  void onDetachedFromWindow();

  void onPauseForTesting();

  void onResumeForTesting();

  void onViewFocusChanged(boolean z);

  void onWindowFocusChanged(boolean z);

  void setAccessDelegate(InternalAccessDelegate internalAccessDelegate);

  void setHideKeyboardOnBlur(boolean z);

  static ViewEventSink from(WebContents webContents) {
    return ViewEventSinkImpl.from(webContents);
  }
}
