package org.chromium.ui.resources.dynamics;

import android.graphics.Bitmap;
import android.graphics.Rect;
import org.chromium.ui.resources.Resource;
import org.chromium.ui.resources.statics.NinePatchData;

public class DynamicResourceSnapshot implements Resource {
  private final Bitmap mBitmap;
  private final Rect mBitmapSize;
  private final long mNativeResourceId;
  private final boolean mShouldRemoveResourceOnNullBitmap;

  public DynamicResourceSnapshot(
      Bitmap bitmap,
      boolean shouldRemoveResourceOnNullBitmap,
      Rect bitmapSize,
      long nativeResourceId) {
    this.mBitmap = bitmap;
    this.mShouldRemoveResourceOnNullBitmap = shouldRemoveResourceOnNullBitmap;
    this.mBitmapSize = bitmapSize;
    this.mNativeResourceId = nativeResourceId;
  }

  @Override
  public Bitmap getBitmap() {
    return this.mBitmap;
  }

  @Override
  public boolean shouldRemoveResourceOnNullBitmap() {
    return this.mShouldRemoveResourceOnNullBitmap;
  }

  @Override
  public Rect getBitmapSize() {
    return this.mBitmapSize;
  }

  @Override
  public NinePatchData getNinePatchData() {
    return null;
  }

  @Override
  public long createNativeResource() {
    return this.mNativeResourceId;
  }
}
