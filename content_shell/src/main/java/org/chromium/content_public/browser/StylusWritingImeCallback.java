package org.chromium.content_public.browser;

import android.view.View;
import org.chromium.blink.mojom.StylusWritingGestureData;

public interface StylusWritingImeCallback {
  void finishComposingText();

  View getContainerView();

  void handleStylusWritingGestureAction(int i, StylusWritingGestureData stylusWritingGestureData);

  void hideKeyboard();

  void performEditorAction(int i);

  void resetGestureDetection();

  void sendCompositionToNative(CharSequence charSequence, int i, boolean z);

  void setEditableSelectionOffsets(int i, int i2);

  void showSoftKeyboard();
}
