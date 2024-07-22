package org.chromium.content_public.browser;

import org.chromium.content.browser.RenderCoordinatesImpl;

public interface RenderCoordinates {
  int getContentHeightPixInt();

  int getContentOffsetYPixInt();

  int getContentWidthPixInt();

  int getLastFrameViewportHeightPixInt();

  int getLastFrameViewportWidthPixInt();

  int getMaxHorizontalScrollPixInt();

  int getMaxVerticalScrollPixInt();

  float getMinPageScaleFactor();

  float getPageScaleFactor();

  int getPageScaleFactorInt();

  int getScrollXPixInt();

  int getScrollYPixInt();

  static RenderCoordinates fromWebContents(WebContents webContents) {
    return RenderCoordinatesImpl.fromWebContents(webContents);
  }
}
