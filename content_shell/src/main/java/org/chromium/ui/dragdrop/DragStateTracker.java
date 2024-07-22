package org.chromium.ui.dragdrop;

import android.view.View;

public interface DragStateTracker extends View.OnDragListener {
  default boolean isDragStarted() {
    return false;
  }

  default int getDragShadowWidth() {
    return 0;
  }

  default int getDragShadowHeight() {
    return 0;
  }

  default void destroy() {}
}
