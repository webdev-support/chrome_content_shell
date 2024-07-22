package org.chromium.content_public.browser;

import android.view.KeyEvent;

public interface ImeEventObserver {
  default void onImeEvent() {}

  default void onNodeAttributeUpdated(boolean editable, boolean password) {}

  default void onBeforeSendKeyEvent(KeyEvent event) {}
}
