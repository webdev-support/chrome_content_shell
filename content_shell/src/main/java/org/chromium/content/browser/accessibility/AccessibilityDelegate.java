package org.chromium.content.browser.accessibility;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewStructure;
import org.chromium.content_public.browser.WebContents;

public interface AccessibilityDelegate {

  public interface AccessibilityCoordinates {
    float fromLocalCssToPix(float f);

    float getContentHeightCss();

    float getContentOffsetYPix();

    float getContentWidthCss();

    int getLastFrameViewportHeightPixInt();

    float getScrollX();

    float getScrollXPix();

    float getScrollY();

    float getScrollYPix();
  }

  AccessibilityCoordinates getAccessibilityCoordinates();

  View getContainerView();

  String getProductVersion();

  WebContents getWebContents();

  boolean isIncognito();

  void requestAccessibilitySnapshot(ViewStructure viewStructure, Runnable runnable);

  default long getNativeAXTree() {
    return 0L;
  }

  default void setOnScrollPositionChangedCallback(Runnable onScrollCallback) {}

  default boolean performClick(Rect nodeRect) {
    return false;
  }

  default boolean scrollToMakeNodeVisible(Rect nodeRect) {
    return false;
  }
}
