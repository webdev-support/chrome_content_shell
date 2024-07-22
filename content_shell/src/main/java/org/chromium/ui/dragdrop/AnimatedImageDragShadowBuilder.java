package org.chromium.ui.dragdrop;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Shader;
import android.media.ThumbnailUtils;
import android.util.FloatProperty;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.example.chromium_content_view.R;

public class AnimatedImageDragShadowBuilder extends View.DragShadowBuilder {

  private static final int ANIMATION_DURATION_MS = 300;
  private static final int MAX_ALPHA_VALUE = 255;
  private static final float TARGET_ALPHA_RATIO = 0.6f;
  private final RectF mBitmapRect;
  private final RectF mBorderBounds;
  private final int mBorderSize;
  private final RectF mCanvasRect;
  private final View mContainerView;
  private final RectF mCurrentBounds;
  private final RectF mEndBounds;
  private final float mEndCornerRadius;
  private final Paint mPaint;
  private final Paint mPaintBorder;
  private float mProgress;
  private final FloatProperty<AnimatedImageDragShadowBuilder> mProgressProperty =
      new FloatProperty<AnimatedImageDragShadowBuilder>("progress") {
        @Override // android.util.FloatProperty
        public void setValue(
            AnimatedImageDragShadowBuilder animatedImageDragShadowBuilder, float v) {
          animatedImageDragShadowBuilder.mProgress = v;
          animatedImageDragShadowBuilder.mContainerView.updateDragShadow(
              animatedImageDragShadowBuilder);
        }

        @Override // android.util.Property
        public Float get(AnimatedImageDragShadowBuilder animatedImageDragShadowBuilder) {
          return Float.valueOf(animatedImageDragShadowBuilder.mProgress);
        }
      };
  private final RectF mStartBounds;
  private final float mStartCornerRadius;
  private final Matrix mTransformMatrix;

  public AnimatedImageDragShadowBuilder(
      View containerView,
      Bitmap bitmap,
      float startX,
      float startY,
      DragShadowSpec dragShadowSpec) {
    RectF rectF = new RectF();
    this.mStartBounds = rectF;
    RectF rectF2 = new RectF();
    this.mEndBounds = rectF2;
    this.mCurrentBounds = new RectF();
    this.mBorderBounds = new RectF();
    RectF rectF3 = new RectF();
    this.mCanvasRect = rectF3;
    this.mContainerView = containerView;
    Bitmap croppedDragShadow =
        ThumbnailUtils.extractThumbnail(
            bitmap, dragShadowSpec.startWidth, dragShadowSpec.startHeight, 2);
    float resizeRatio = dragShadowSpec.targetWidth / dragShadowSpec.startWidth;
    Resources res = containerView.getResources();
    Context context = containerView.getContext();
    this.mProgress = 0.0f;
    rectF.set(0.0f, 0.0f, dragShadowSpec.startWidth, dragShadowSpec.startHeight);
    rectF2.set(0.0f, 0.0f, dragShadowSpec.targetWidth, dragShadowSpec.targetHeight);
    centerRectAtPoint(rectF2, startX, startY);
    rectF3.set(rectF);
    rectF3.union(rectF2);
    int dimensionPixelSize = res.getDimensionPixelSize(R.dimen.drag_shadow_border_size);
    this.mBorderSize = dimensionPixelSize;
    rectF3.left -= dimensionPixelSize;
    rectF3.top -= dimensionPixelSize;
    rectF3.right += dimensionPixelSize;
    rectF3.bottom += dimensionPixelSize;
    float canvasOffsetX = -rectF3.left;
    float canvasOffsetY = -rectF3.top;
    rectF3.offset(canvasOffsetX, canvasOffsetY);
    rectF.offset(canvasOffsetX, canvasOffsetY);
    rectF2.offset(canvasOffsetX, canvasOffsetY);
    float dimensionPixelSize2 = res.getDimensionPixelSize(R.dimen.drag_shadow_border_corner_radius);
    this.mEndCornerRadius = dimensionPixelSize2;
    this.mStartCornerRadius = dimensionPixelSize2 / resizeRatio;
    this.mBitmapRect =
        new RectF(0.0f, 0.0f, croppedDragShadow.getWidth(), croppedDragShadow.getHeight());
    BitmapShader shader =
        new BitmapShader(croppedDragShadow, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    Paint paint = new Paint();
    this.mPaint = paint;
    paint.setShader(shader);
    Paint paint2 = new Paint();
    this.mPaintBorder = paint2;
    paint2.setStyle(Paint.Style.STROKE);
    paint2.setStrokeWidth(dimensionPixelSize);
    paint2.setColor(context.getColor(R.color.drag_shadow_outline_color));
    this.mTransformMatrix = new Matrix();
  }

  @Override // android.view.View.DragShadowBuilder
  public void onProvideShadowMetrics(Point outShadowSize, Point outShadowTouchPoint) {
    outShadowSize.set(Math.round(this.mCanvasRect.width()), Math.round(this.mCanvasRect.height()));
    outShadowTouchPoint.set(
        Math.round(this.mEndBounds.centerX()), Math.round(this.mEndBounds.centerY()));
    ObjectAnimator animator = ObjectAnimator.ofFloat(this, this.mProgressProperty, 1.0f);
    animator.setAutoCancel(true);
    animator.setDuration(300L);
    animator.start();
  }

  @Override // android.view.View.DragShadowBuilder
  public void onDrawShadow(Canvas canvas) {
    this.mCurrentBounds.set(
        lerp(this.mStartBounds.left, this.mEndBounds.left, this.mProgress),
        lerp(this.mStartBounds.top, this.mEndBounds.top, this.mProgress),
        lerp(this.mStartBounds.right, this.mEndBounds.right, this.mProgress),
        lerp(this.mStartBounds.bottom, this.mEndBounds.bottom, this.mProgress));
    this.mTransformMatrix.setRectToRect(
        this.mBitmapRect, this.mCurrentBounds, Matrix.ScaleToFit.CENTER);
    this.mPaint.getShader().setLocalMatrix(this.mTransformMatrix);
    float cornerRadius = lerp(this.mStartCornerRadius, this.mEndCornerRadius, this.mProgress);
    this.mPaint.setAlpha(Math.round((1.0f - (this.mProgress * 0.39999998f)) * 255.0f));
    canvas.drawRoundRect(this.mCurrentBounds, cornerRadius, cornerRadius, this.mPaint);
    this.mBorderBounds.set(
        this.mCurrentBounds.left - (this.mBorderSize / 2.0f),
        this.mCurrentBounds.top - (this.mBorderSize / 2.0f),
        this.mCurrentBounds.right + (this.mBorderSize / 2.0f),
        this.mCurrentBounds.bottom + (this.mBorderSize / 2.0f));
    canvas.drawRoundRect(this.mBorderBounds, cornerRadius, cornerRadius, this.mPaintBorder);
  }

  private static void centerRectAtPoint(RectF centerThisRect, float atX, float atY) {
    centerThisRect.offset(atX - centerThisRect.centerX(), atY - centerThisRect.centerY());
  }

  private static float lerp(float start, float stop, float amount) {
    return ((stop - start) * amount) + start;
  }

  public static DragShadowSpec getDragShadowSpec(
      Context context, int imageWidth, int imageHeight, int windowWidth, int windowHeight) {
    float truncatedWidth;
    Resources resources = context.getResources();
    float startWidth = imageWidth;
    float startHeight = imageHeight;
    float truncatedHeight = 0.0f;
    float resizeRatio = ResourcesCompat.getFloat(resources, R.dimen.drag_shadow_resize_ratio);
    float targetWidth = startWidth * resizeRatio;
    float targetHeight = startHeight * resizeRatio;
    float maxSizeRatio =
        ResourcesCompat.getFloat(resources, R.dimen.drag_shadow_max_size_to_window_ratio);
    float maxHeightPx = windowHeight * maxSizeRatio;
    float maxWidthPx = windowWidth * maxSizeRatio;
    if (targetWidth > maxWidthPx || targetHeight > maxHeightPx) {
      truncatedWidth = 0.0f;
      float truncatedWidth2 = maxWidthPx / targetWidth;
      float downScaleRatio = Math.min(maxHeightPx / targetHeight, truncatedWidth2);
      targetWidth *= downScaleRatio;
      targetHeight *= downScaleRatio;
    } else {
      truncatedWidth = 0.0f;
    }
    int minSizePx = getDragShadowMinSize(resources);
    if (targetWidth <= targetHeight && targetWidth < minSizePx) {
      float scaleUpRatio = minSizePx / targetWidth;
      targetHeight *= scaleUpRatio;
      targetWidth *= scaleUpRatio;
      if (targetHeight > maxHeightPx) {
        targetHeight = maxHeightPx;
        float startHeight2 = (targetHeight / targetWidth) * startWidth;
        truncatedHeight = (imageHeight - startHeight2) / 2.0f;
        startHeight = startHeight2;
      }
    } else if (targetHeight < minSizePx) {
      float scaleUpRatio2 = minSizePx / targetHeight;
      targetHeight *= scaleUpRatio2;
      targetWidth *= scaleUpRatio2;
      if (targetWidth > maxWidthPx) {
        targetWidth = maxWidthPx;
        startWidth = (targetWidth / targetHeight) * startHeight;
        truncatedWidth = (imageWidth - startWidth) / 2.0f;
      }
    }
    return new DragShadowSpec(
        Math.round(startWidth),
        Math.round(startHeight),
        Math.round(targetWidth),
        Math.round(targetHeight),
        Math.round(truncatedWidth),
        Math.round(truncatedHeight));
  }

  public static CursorOffset adjustCursorOffset(
      float cursorOffsetX,
      float cursorOffsetY,
      int dragObjRectWidth,
      int dragObjRectHeight,
      DragShadowSpec dragShadowSpec) {
    if (dragShadowSpec.truncatedHeight == 0 || dragShadowSpec.truncatedWidth == 0) {
      if (dragShadowSpec.truncatedHeight != 0) {
        float scaleFactor = dragShadowSpec.startWidth / dragObjRectWidth;
        float adjustedOffsetX = cursorOffsetX * scaleFactor;
        float adjustedOffsetY = cursorOffsetY * scaleFactor;
        return new CursorOffset(
            adjustedOffsetX,
            Math.min(
                dragShadowSpec.startHeight,
                Math.max(0.0f, adjustedOffsetY - dragShadowSpec.truncatedHeight)));
      } else if (dragShadowSpec.truncatedWidth != 0) {
        float scaleFactor2 = dragShadowSpec.startHeight / dragObjRectHeight;
        float adjustedOffsetX2 = cursorOffsetX * scaleFactor2;
        float adjustedOffsetY2 = cursorOffsetY * scaleFactor2;
        return new CursorOffset(
            Math.min(
                dragShadowSpec.startWidth,
                Math.max(0.0f, adjustedOffsetX2 - dragShadowSpec.truncatedWidth)),
            adjustedOffsetY2);
      } else {
        float scaleFactor3 = dragShadowSpec.startWidth / dragObjRectWidth;
        float adjustedOffsetX3 = cursorOffsetX * scaleFactor3;
        float adjustedOffsetY3 = cursorOffsetY * scaleFactor3;
        return new CursorOffset(adjustedOffsetX3, adjustedOffsetY3);
      }
    }
    throw new AssertionError("Drag shadow should not be truncated in both dimensions");
  }

  public static int getDragShadowMinSize(Resources resources) {
    return resources.getDimensionPixelSize(R.dimen.drag_shadow_min_size);
  }

  static class DragShadowSpec {
    public final int startHeight;
    public final int startWidth;
    public final int targetHeight;
    public final int targetWidth;
    public final int truncatedHeight;
    public final int truncatedWidth;

    DragShadowSpec(
        int startWidth,
        int startHeight,
        int targetWidth,
        int targetHeight,
        int truncatedWidth,
        int truncatedHeight) {
      this.startWidth = startWidth;
      this.startHeight = startHeight;
      this.targetWidth = targetWidth;
      this.targetHeight = targetHeight;
      this.truncatedWidth = truncatedWidth;
      this.truncatedHeight = truncatedHeight;
    }
  }

  static class CursorOffset {
    public final float x;
    public final float y;

    CursorOffset(float x, float y) {
      this.x = x;
      this.y = y;
    }
  }
}
