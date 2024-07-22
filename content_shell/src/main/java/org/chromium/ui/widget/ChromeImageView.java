package org.chromium.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import org.chromium.base.Log;

public class ChromeImageView extends AppCompatImageView {
  private static final String TAG = "CIV";

  public ChromeImageView(Context context) {
    super(context);
  }

  public ChromeImageView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public ChromeImageView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override // android.widget.ImageView, android.view.View
  protected void onDraw(Canvas canvas) {
    Bitmap bitmap;
    Drawable drawable = getDrawable();
    if (drawable != null
        && (drawable instanceof BitmapDrawable)
        && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null
        && bitmap.isRecycled()) {
      Log.e(TAG, "Trying to draw with recycled BitmapDrawable. Id: " + getId());
    }
    super.onDraw(canvas);
  }
}
