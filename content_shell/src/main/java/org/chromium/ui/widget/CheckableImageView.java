package org.chromium.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;

public class CheckableImageView extends ChromeImageView implements Checkable {
  private static final int[] CHECKED_STATE_SET = {16842912};
  private boolean mChecked;

  public CheckableImageView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override // android.widget.ImageView, android.view.View
  public int[] onCreateDrawableState(int extraSpace) {
    if (isChecked()) {
      int[] iArr = CHECKED_STATE_SET;
      int[] drawableState = super.onCreateDrawableState(iArr.length + extraSpace);
      return mergeDrawableStates(drawableState, iArr);
    }
    return super.onCreateDrawableState(extraSpace);
  }

  @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
  public void setImageDrawable(Drawable drawable) {
    if (drawable == getDrawable()) {
      return;
    }
    super.setImageDrawable(drawable);
    refreshDrawableState();
  }

  @Override // android.widget.Checkable
  public void toggle() {
    setChecked(!this.mChecked);
  }

  @Override // android.widget.Checkable
  public boolean isChecked() {
    return this.mChecked;
  }

  @Override // android.widget.Checkable
  public void setChecked(boolean checked) {
    if (this.mChecked == checked) {
      return;
    }
    this.mChecked = checked;
    refreshDrawableState();
  }
}
