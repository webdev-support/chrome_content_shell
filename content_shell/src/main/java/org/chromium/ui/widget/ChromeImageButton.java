package org.chromium.ui.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageButton;

public class ChromeImageButton extends AppCompatImageButton {
  public ChromeImageButton(Context context) {
    super(context);
  }

  public ChromeImageButton(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public ChromeImageButton(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override // android.view.View
  public void onFinishInflate() {
    super.onFinishInflate();
    if (getImageTintList() != null && getImageTintMode() == PorterDuff.Mode.SRC_ATOP) {
      setImageTintMode(PorterDuff.Mode.SRC_IN);
    }
  }
}
