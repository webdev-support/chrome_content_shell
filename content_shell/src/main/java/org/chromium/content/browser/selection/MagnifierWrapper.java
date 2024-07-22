package org.chromium.content.browser.selection;

public interface MagnifierWrapper {
  void childLocalSurfaceIdChanged();

  void dismiss();

  boolean isAvailable();

  void show(float f, float f2);
}
