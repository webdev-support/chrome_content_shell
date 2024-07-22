package org.chromium.ui.dragdrop;

import android.graphics.Bitmap;
import android.view.View;

public interface DragAndDropDelegate {
  boolean startDragAndDrop(
      View view, Bitmap bitmap, DropDataAndroid dropDataAndroid, int i, int i2, int i3, int i4);

  boolean startDragAndDrop(
      View view, View.DragShadowBuilder dragShadowBuilder, DropDataAndroid dropDataAndroid);

  default void setDragAndDropBrowserDelegate(DragAndDropBrowserDelegate delegate) {}

  default void destroy() {}
}
