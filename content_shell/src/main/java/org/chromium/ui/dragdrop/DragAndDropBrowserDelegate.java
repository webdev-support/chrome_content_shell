package org.chromium.ui.dragdrop;

import android.content.ClipData;
import android.content.Intent;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

public interface DragAndDropBrowserDelegate {
  ClipData buildClipData(DropDataAndroid dropDataAndroid);

  Intent createUrlIntent(String str, int i);

  DragAndDropPermissions getDragAndDropPermissions(DragEvent dragEvent);

  boolean getSupportAnimatedImageDragShadow();

  boolean getSupportDropInChrome();
}
