package org.chromium.ui.resources.dynamics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

public class CaptureUtils {
  public static Bitmap createBitmap(int width, int height) {
    Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
    bitmap.setHasAlpha(true);
    return bitmap;
  }

  public static boolean captureCommon(
      Canvas canvas,
      View view,
      Rect dirtyRect,
      float scale,
      boolean drawWhileDetached,
      CaptureObserver observer) {
    boolean willDraw = drawWhileDetached || view.isAttachedToWindow();
    if (!willDraw) {
      return false;
    }
    observer.onCaptureStart(canvas, dirtyRect.isEmpty() ? null : dirtyRect);
    if (!dirtyRect.isEmpty()) {
      canvas.clipRect(dirtyRect);
    }
    canvas.save();
    canvas.scale(scale, scale);
    view.draw(canvas);
    canvas.restore();
    observer.onCaptureEnd();
    return true;
  }
}
