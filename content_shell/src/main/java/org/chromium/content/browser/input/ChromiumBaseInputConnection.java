package org.chromium.content.browser.input;

import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

public interface ChromiumBaseInputConnection extends InputConnection {

  public interface Factory {
    Handler getHandler();

    ChromiumBaseInputConnection initializeAndGet(
        View view,
        ImeAdapterImpl imeAdapterImpl,
        int i,
        int i2,
        int i3,
        int i4,
        int i5,
        int i6,
        String str,
        EditorInfo editorInfo);

    void onViewAttachedToWindow();

    void onViewDetachedFromWindow();

    void onViewFocusChanged(boolean z);

    void onWindowFocusChanged(boolean z);

    void setTriggerDelayedOnCreateInputConnection(boolean z);
  }

  @Override // android.view.inputmethod.InputConnection
  Handler getHandler();

  void onRestartInputOnUiThread();

  boolean sendKeyEventOnUiThread(KeyEvent keyEvent);

  void unblockOnUiThread();

  void updateStateOnUiThread(String str, int i, int i2, int i3, int i4, boolean z, boolean z2);
}
