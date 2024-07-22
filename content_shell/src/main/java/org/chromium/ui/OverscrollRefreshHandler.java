package org.chromium.ui;

public interface OverscrollRefreshHandler {
  void pull(float f, float f2);

  void release(boolean z);

  void reset();

  void setEnabled(boolean z);

  boolean start(int i, float f, float f2, boolean z);
}
