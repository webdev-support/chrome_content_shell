package org.chromium.content.browser.webcontents;

import android.view.KeyEvent;
import android.view.MotionEvent;
import org.chromium.content_public.browser.ViewEventSink;

public class EmptyInternalAccessDelegate implements ViewEventSink.InternalAccessDelegate {
  @Override
  public boolean super_onKeyUp(int keyCode, KeyEvent event) {
    return false;
  }

  @Override
  public boolean super_dispatchKeyEvent(KeyEvent event) {
    return false;
  }

  @Override
  public boolean super_onGenericMotionEvent(MotionEvent event) {
    return false;
  }

  @Override
  public void onScrollChanged(int lPix, int tPix, int oldlPix, int oldtPix) {}
}
