package org.chromium.ui.base;

import android.graphics.Rect;
import android.view.Window;

public class WindowDelegate {
  private final Window mWindow;

  public WindowDelegate(Window window) {
    this.mWindow = window;
  }

  public int getWindowSoftInputMode() {
    return this.mWindow.getAttributes().softInputMode;
  }

  public void setWindowSoftInputMode(int softInputMode) {
    this.mWindow.setSoftInputMode(softInputMode);
  }

  public void getWindowVisibleDisplayFrame(Rect displayFrame) {
    this.mWindow.getDecorView().getWindowVisibleDisplayFrame(displayFrame);
  }

  public int getDecorViewHeight() {
    return this.mWindow.getDecorView().getHeight();
  }
}
