package org.chromium.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class DropdownDividerDrawable extends Drawable {
  private final Integer mBackgroundColor;
  private final Paint mPaint = new Paint();
  private final Rect mDividerRect = new Rect();

  public DropdownDividerDrawable(Integer backgroundColor) {
    this.mBackgroundColor = backgroundColor;
  }

  @Override // android.graphics.drawable.Drawable
  public void draw(Canvas canvas) {
    Integer num = this.mBackgroundColor;
    if (num != null) {
      canvas.drawColor(num.intValue());
    }
    canvas.drawRect(this.mDividerRect, this.mPaint);
  }

  @Override // android.graphics.drawable.Drawable
  public void onBoundsChange(Rect bounds) {
    this.mDividerRect.set(0, 0, bounds.width(), this.mDividerRect.height());
  }

  public void setHeight(int height) {
    Rect rect = this.mDividerRect;
    rect.set(0, 0, rect.right, height);
  }

  public void setDividerColor(int color) {
    this.mPaint.setColor(color);
  }

  @Override // android.graphics.drawable.Drawable
  public void setAlpha(int alpha) {}

  @Override // android.graphics.drawable.Drawable
  public void setColorFilter(ColorFilter cf) {}

  @Override // android.graphics.drawable.Drawable
  public int getOpacity() {
    return -2;
  }
}
