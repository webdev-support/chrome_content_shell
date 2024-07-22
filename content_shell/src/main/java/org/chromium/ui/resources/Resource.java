package org.chromium.ui.resources;

import android.graphics.Bitmap;
import android.graphics.Rect;
import org.chromium.ui.resources.statics.NinePatchData;

public interface Resource {
  long createNativeResource();

  Bitmap getBitmap();

  Rect getBitmapSize();

  NinePatchData getNinePatchData();

  boolean shouldRemoveResourceOnNullBitmap();
}
