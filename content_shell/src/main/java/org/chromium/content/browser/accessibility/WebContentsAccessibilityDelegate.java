package org.chromium.content.browser.accessibility;

import android.view.View;
import android.view.ViewStructure;
import org.chromium.content.browser.RenderCoordinatesImpl;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.WebContents;

public class WebContentsAccessibilityDelegate implements AccessibilityDelegate {
  private final AccessibilityCoordinatesImpl mAccessibilityCoordinatesImpl =
      new AccessibilityCoordinatesImpl();
  private final WebContentsImpl mWebContents;

  public WebContentsAccessibilityDelegate(WebContents webContents) {
    this.mWebContents = (WebContentsImpl) webContents;
  }

  @Override
  public View getContainerView() {
    return this.mWebContents.getViewAndroidDelegate().getContainerView();
  }

  @Override
  public String getProductVersion() {
    return this.mWebContents.getProductVersion();
  }

  @Override
  public boolean isIncognito() {
    return this.mWebContents.isIncognito();
  }

  @Override
  public WebContents getWebContents() {
    return this.mWebContents;
  }

  @Override
  public AccessibilityDelegate.AccessibilityCoordinates getAccessibilityCoordinates() {
    return this.mAccessibilityCoordinatesImpl;
  }

  @Override
  public void requestAccessibilitySnapshot(ViewStructure root, Runnable doneCallback) {
    this.mWebContents.requestAccessibilitySnapshot(root, doneCallback);
  }

  class AccessibilityCoordinatesImpl implements AccessibilityDelegate.AccessibilityCoordinates {
    AccessibilityCoordinatesImpl() {}

    @Override
    public float fromLocalCssToPix(float css) {
      return getRenderCoordinates().fromLocalCssToPix(css);
    }

    @Override
    public float getContentOffsetYPix() {
      return getRenderCoordinates().getContentOffsetYPix();
    }

    @Override
    public float getScrollXPix() {
      return getRenderCoordinates().getScrollXPix();
    }

    @Override
    public float getScrollYPix() {
      return getRenderCoordinates().getScrollYPix();
    }

    @Override
    public float getContentWidthCss() {
      return getRenderCoordinates().getContentWidthCss();
    }

    @Override
    public float getContentHeightCss() {
      return getRenderCoordinates().getContentHeightCss();
    }

    @Override
    public float getScrollX() {
      return getRenderCoordinates().getScrollX();
    }

    @Override
    public float getScrollY() {
      return getRenderCoordinates().getScrollY();
    }

    @Override
    public int getLastFrameViewportHeightPixInt() {
      return getRenderCoordinates().getLastFrameViewportHeightPixInt();
    }

    private RenderCoordinatesImpl getRenderCoordinates() {
      return WebContentsAccessibilityDelegate.this.mWebContents.getRenderCoordinates();
    }
  }
}
