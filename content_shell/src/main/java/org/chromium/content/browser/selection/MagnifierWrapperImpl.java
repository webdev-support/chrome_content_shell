package org.chromium.content.browser.selection;

import android.view.View;
import android.widget.Magnifier;

public class MagnifierWrapperImpl implements MagnifierWrapper {
  private static final boolean DEBUG = false;
  private static final String TAG = "Magnifier";
  private SelectionPopupControllerImpl.ReadbackViewCallback mCallback;
  private Magnifier mMagnifier;

  public MagnifierWrapperImpl(SelectionPopupControllerImpl.ReadbackViewCallback callback) {
    this.mCallback = callback;
  }

  @Override
  public void show(float x, float y) {
    View view = this.mCallback.getReadbackView();
    if (view == null) {
      return;
    }
    if (this.mMagnifier == null) {
      this.mMagnifier = new Magnifier(view);
    }
    this.mMagnifier.show(x, y);
  }

  @Override
  public void dismiss() {
    Magnifier magnifier = this.mMagnifier;
    if (magnifier != null) {
      magnifier.dismiss();
      this.mMagnifier = null;
    }
  }

  @Override
  public boolean isAvailable() {
    return this.mCallback.getReadbackView() != null;
  }

  @Override
  public void childLocalSurfaceIdChanged() {}
}
