package org.chromium.ui.resources.system;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import org.chromium.ui.resources.Resource;
import org.chromium.ui.resources.async.AsyncPreloadResourceLoader;
import org.chromium.ui.resources.statics.StaticResource;

public class SystemResourceLoader extends AsyncPreloadResourceLoader {

  private static final float COS_PI_OVER_6 = 0.866f;
  private static final float SIN_PI_OVER_6 = 0.5f;

  public SystemResourceLoader(
      int resourceType, ResourceLoaderCallback callback, final int minScreenSideLengthPx) {
    super(
        resourceType,
        callback,
        new ResourceCreator() {
          @Override
          public Resource create(int resId) {
            return SystemResourceLoader.createResource(minScreenSideLengthPx, resId);
          }
        });
  }

  public static Resource createResource(int minScreenSideLengthPx, int resId) {
    switch (resId) {
      case 0:
        return createOverscrollGlowBitmap(minScreenSideLengthPx);
      default:
        throw new AssertionError();
    }
  }

  private static Resource createOverscrollGlowBitmap(int minScreenSideLengthPx) {
    float arcWidth = (minScreenSideLengthPx * 0.5f) / 0.5f;
    float y = COS_PI_OVER_6 * arcWidth;
    float height = arcWidth - y;
    float arcRectX = (-arcWidth) / 2.0f;
    float arcRectY = (-arcWidth) - y;
    float arcRectWidth = arcWidth * 2.0f;
    float arcRectHeight = 2.0f * arcWidth;
    RectF arcRect =
        new RectF(arcRectX, arcRectY, arcRectX + arcRectWidth, arcRectY + arcRectHeight);
    Paint arcPaint = new Paint();
    arcPaint.setAntiAlias(true);
    arcPaint.setAlpha(187);
    arcPaint.setStyle(Paint.Style.FILL);
    Bitmap bitmap = Bitmap.createBitmap((int) arcWidth, (int) height, Bitmap.Config.ALPHA_8);
    Canvas canvas = new Canvas(bitmap);
    canvas.drawArc(arcRect, 45.0f, 90.0f, true, arcPaint);
    return new StaticResource(bitmap);
  }
}
