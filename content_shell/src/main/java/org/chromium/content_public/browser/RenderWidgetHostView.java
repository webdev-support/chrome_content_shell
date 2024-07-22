package org.chromium.content_public.browser;

import org.chromium.base.Callback;

public interface RenderWidgetHostView {
  int getBackgroundColor();

  boolean isReady();

  void onViewportInsetBottomChanged();

  void writeContentBitmapToDiskAsync(int i, int i2, String str, Callback<String> callback);
}
