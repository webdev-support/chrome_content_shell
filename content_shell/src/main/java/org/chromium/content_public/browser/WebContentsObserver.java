package org.chromium.content_public.browser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import org.chromium.ui.base.WindowAndroid;
import org.chromium.url.GURL;

public abstract class WebContentsObserver {
  protected WeakReference<WebContents> mWebContents;

  @Retention(RetentionPolicy.SOURCE)
  public @interface ViewportFitType {}

  public WebContentsObserver(WebContents webContents) {
    this.mWebContents = new WeakReference<>(webContents);
    webContents.addObserver(this);
  }

  public void renderFrameCreated(GlobalRenderFrameHostId id) {}

  public void renderFrameDeleted(GlobalRenderFrameHostId id) {}

  public void renderProcessGone() {}

  public void didStartNavigationInPrimaryMainFrame(NavigationHandle navigationHandle) {}

  public void didRedirectNavigation(NavigationHandle navigationHandle) {}

  public void didFinishNavigationInPrimaryMainFrame(NavigationHandle navigationHandle) {}

  public void didStartLoading(GURL url) {}

  public void didStopLoading(GURL url, boolean isKnownValid) {}

  public void loadProgressChanged(float progress) {}

  public void didChangeVisibleSecurityState() {}

  public void didFailLoad(
      boolean isInPrimaryMainFrame, int errorCode, GURL failingUrl, int rfhLifecycleState) {}

  public void didFirstVisuallyNonEmptyPaint() {}

  public void wasShown() {}

  public void wasHidden() {}

  public void titleWasSet(String title) {}

  public void primaryMainDocumentElementAvailable() {}

  public void didFinishLoadInPrimaryMainFrame(
      GlobalRenderFrameHostId rfhId, GURL url, boolean isKnownValid, int rfhLifecycleState) {}

  public void documentLoadedInPrimaryMainFrame(
      GlobalRenderFrameHostId rfhId, int rfhLifecycleState) {}

  public void navigationEntryCommitted(LoadCommittedDetails details) {}

  public void navigationEntriesDeleted() {}

  public void navigationEntriesChanged() {}

  public void frameReceivedUserActivation() {}

  public void didChangeThemeColor() {}

  public void mediaStartedPlaying() {}

  public void mediaStoppedPlaying() {}

  public void hasEffectivelyFullscreenVideoChange(boolean isFullscreen) {}

  public void didToggleFullscreenModeForTab(boolean enteredFullscreen, boolean willCauseResize) {}

  public void viewportFitChanged(int value) {}

  public void virtualKeyboardModeChanged(int mode) {}

  public void onWebContentsFocused() {}

  public void onWebContentsLostFocus() {}

  public void onTopLevelNativeWindowChanged(WindowAndroid windowAndroid) {}

  public void destroy() {
    WeakReference<WebContents> weakReference = this.mWebContents;
    if (weakReference == null) {
      return;
    }
    WebContents webContents = weakReference.get();
    this.mWebContents = null;
    if (webContents == null) {
      return;
    }
    webContents.removeObserver(this);
  }

  public WebContentsObserver() {}
}
