package org.chromium.content_public.browser;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorBoundsInfo;
import android.view.inputmethod.EditorInfo;

public interface StylusWritingHandler {
  boolean canShowSoftKeyboard();

  boolean shouldInitiateStylusWriting();

  default void updateInputState(String text, int selectionStart, int selectionEnd) {}

  default EditorBoundsInfo onFocusedNodeChanged(
      Rect editableBoundsOnScreenDip,
      boolean isEditable,
      View currentView,
      float scaleFactor,
      int contentOffsetY) {
    return null;
  }

  default boolean handleTouchEvent(MotionEvent event, View currentView) {
    return false;
  }

  default void handleHoverEvent(MotionEvent event, View currentView) {}

  default void updateEditorInfo(EditorInfo editorInfo) {}

  default void onDetachedFromWindow(Context context) {}

  default void onFocusChanged(boolean hasFocus) {}

  default EditorBoundsInfo onEditElementFocusedForStylusWriting(
      Rect focusedEditBounds,
      Point cursorPosition,
      float scaleFactor,
      int contentOffsetY,
      View view) {
    return null;
  }

  default void onImeAdapterDestroyed() {}
}
