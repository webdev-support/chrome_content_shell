package org.chromium.content.browser.framehost;

import android.graphics.Bitmap;
import android.os.SystemClock;
import org.chromium.base.Log;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.content_public.browser.AdditionalNavigationParams;
import org.chromium.content_public.browser.LoadUrlParams;
import org.chromium.content_public.browser.NavigationController;
import org.chromium.content_public.browser.NavigationEntry;
import org.chromium.content_public.browser.NavigationHandle;
import org.chromium.content_public.browser.NavigationHistory;
import org.chromium.content_public.common.ResourceRequestBody;
import org.chromium.url.GURL;
import org.chromium.url.Origin;
import org.jni_zero.JNINamespace;

@JNINamespace("content")
class NavigationControllerImpl implements NavigationController {
  private static final String TAG = "NavigationController";
  private long mNativeNavigationControllerAndroid;

  public interface Natives {
    boolean canGoBack(long j, NavigationControllerImpl navigationControllerImpl);

    boolean canGoForward(long j, NavigationControllerImpl navigationControllerImpl);

    boolean canGoToOffset(long j, NavigationControllerImpl navigationControllerImpl, int i);

    void cancelPendingReload(long j, NavigationControllerImpl navigationControllerImpl);

    void clearHistory(long j, NavigationControllerImpl navigationControllerImpl);

    void clearSslPreferences(long j, NavigationControllerImpl navigationControllerImpl);

    void continuePendingReload(long j, NavigationControllerImpl navigationControllerImpl);

    void getDirectedNavigationHistory(
        long j,
        NavigationControllerImpl navigationControllerImpl,
        NavigationHistory navigationHistory,
        boolean z,
        int i);

    NavigationEntry getEntryAtIndex(
        long j, NavigationControllerImpl navigationControllerImpl, int i);

    String getEntryExtraData(
        long j, NavigationControllerImpl navigationControllerImpl, int i, String str);

    int getLastCommittedEntryIndex(long j, NavigationControllerImpl navigationControllerImpl);

    int getNavigationHistory(long j, NavigationControllerImpl navigationControllerImpl, Object obj);

    NavigationEntry getPendingEntry(long j, NavigationControllerImpl navigationControllerImpl);

    boolean getUseDesktopUserAgent(long j, NavigationControllerImpl navigationControllerImpl);

    NavigationEntry getVisibleEntry(long j, NavigationControllerImpl navigationControllerImpl);

    void goBack(long j, NavigationControllerImpl navigationControllerImpl);

    void goForward(long j, NavigationControllerImpl navigationControllerImpl);

    void goToNavigationIndex(long j, NavigationControllerImpl navigationControllerImpl, int i);

    void goToOffset(long j, NavigationControllerImpl navigationControllerImpl, int i);

    boolean isInitialNavigation(long j, NavigationControllerImpl navigationControllerImpl);

    void loadIfNecessary(long j, NavigationControllerImpl navigationControllerImpl);

    NavigationHandle loadUrl(
        long j,
        NavigationControllerImpl navigationControllerImpl,
        String str,
        int i,
        int i2,
        String str2,
        int i3,
        int i4,
        String str3,
        ResourceRequestBody resourceRequestBody,
        String str4,
        String str5,
        String str6,
        boolean z,
        boolean z2,
        boolean z3,
        Origin origin,
        boolean z4,
        boolean z5,
        AdditionalNavigationParams additionalNavigationParams,
        long j2,
        long j3,
        boolean z6);

    boolean needsReload(long j, NavigationControllerImpl navigationControllerImpl);

    void pruneForwardEntries(long j, NavigationControllerImpl navigationControllerImpl);

    void reload(long j, NavigationControllerImpl navigationControllerImpl, boolean z);

    void reloadBypassingCache(long j, NavigationControllerImpl navigationControllerImpl, boolean z);

    boolean removeEntryAtIndex(long j, NavigationControllerImpl navigationControllerImpl, int i);

    void setEntryExtraData(
        long j, NavigationControllerImpl navigationControllerImpl, int i, String str, String str2);

    void setNeedsReload(long j, NavigationControllerImpl navigationControllerImpl);

    void setUseDesktopUserAgent(
        long j, NavigationControllerImpl navigationControllerImpl, boolean z, boolean z2, int i);
  }

  private NavigationControllerImpl(long nativeNavigationControllerAndroid) {
    this.mNativeNavigationControllerAndroid = nativeNavigationControllerAndroid;
  }

  private static NavigationControllerImpl create(long nativeNavigationControllerAndroid) {
    return new NavigationControllerImpl(nativeNavigationControllerAndroid);
  }

  private void destroy() {
    this.mNativeNavigationControllerAndroid = 0L;
  }

  @Override
  public boolean canGoBack() {
    return this.mNativeNavigationControllerAndroid != 0
        && NavigationControllerImplJni.get()
            .canGoBack(this.mNativeNavigationControllerAndroid, this);
  }

  @Override
  public boolean canGoForward() {
    return this.mNativeNavigationControllerAndroid != 0
        && NavigationControllerImplJni.get()
            .canGoForward(this.mNativeNavigationControllerAndroid, this);
  }

  @Override
  public boolean canGoToOffset(int offset) {
    return this.mNativeNavigationControllerAndroid != 0
        && NavigationControllerImplJni.get()
            .canGoToOffset(this.mNativeNavigationControllerAndroid, this, offset);
  }

  @Override
  public void goToOffset(int offset) {
    if (this.mNativeNavigationControllerAndroid != 0) {
      NavigationControllerImplJni.get()
          .goToOffset(this.mNativeNavigationControllerAndroid, this, offset);
    }
  }

  @Override
  public void goToNavigationIndex(int index) {
    if (this.mNativeNavigationControllerAndroid != 0) {
      NavigationControllerImplJni.get()
          .goToNavigationIndex(this.mNativeNavigationControllerAndroid, this, index);
    }
  }

  @Override
  public void goBack() {
    if (this.mNativeNavigationControllerAndroid != 0) {
      NavigationControllerImplJni.get().goBack(this.mNativeNavigationControllerAndroid, this);
    }
  }

  @Override
  public void goForward() {
    if (this.mNativeNavigationControllerAndroid != 0) {
      NavigationControllerImplJni.get().goForward(this.mNativeNavigationControllerAndroid, this);
    }
  }

  @Override
  public boolean isInitialNavigation() {
    return this.mNativeNavigationControllerAndroid != 0
        && NavigationControllerImplJni.get()
            .isInitialNavigation(this.mNativeNavigationControllerAndroid, this);
  }

  @Override
  public void loadIfNecessary() {
    if (this.mNativeNavigationControllerAndroid != 0) {
      NavigationControllerImplJni.get()
          .loadIfNecessary(this.mNativeNavigationControllerAndroid, this);
    }
  }

  @Override
  public boolean needsReload() {
    return this.mNativeNavigationControllerAndroid != 0
        && NavigationControllerImplJni.get()
            .needsReload(this.mNativeNavigationControllerAndroid, this);
  }

  @Override
  public void setNeedsReload() {
    NavigationControllerImplJni.get().setNeedsReload(this.mNativeNavigationControllerAndroid, this);
  }

  @Override
  public void reload(boolean checkForRepost) {
    if (this.mNativeNavigationControllerAndroid != 0) {
      NavigationControllerImplJni.get()
          .reload(this.mNativeNavigationControllerAndroid, this, checkForRepost);
    }
  }

  @Override
  public void reloadBypassingCache(boolean checkForRepost) {
    if (this.mNativeNavigationControllerAndroid != 0) {
      NavigationControllerImplJni.get()
          .reloadBypassingCache(this.mNativeNavigationControllerAndroid, this, checkForRepost);
    }
  }

  @Override
  public void cancelPendingReload() {
    if (this.mNativeNavigationControllerAndroid != 0) {
      NavigationControllerImplJni.get()
          .cancelPendingReload(this.mNativeNavigationControllerAndroid, this);
    }
  }

  @Override
  public void continuePendingReload() {
    if (this.mNativeNavigationControllerAndroid != 0) {
      NavigationControllerImplJni.get()
          .continuePendingReload(this.mNativeNavigationControllerAndroid, this);
    }
  }

  @Override
  public NavigationHandle loadUrl(LoadUrlParams params) {
    String headers;
    long inputStartTimestamp;
    String str;
    int i;
    long longValue;
    if (this.mNativeNavigationControllerAndroid != 0) {
      if (params.getExtraHeaders() == null) {
        headers = params.getVerbatimHeaders();
      } else {
        headers = params.getExtraHeadersString();
      }
      if (params.getInputStartTimestamp() == 0) {
        inputStartTimestamp = params.getIntentReceivedTimestamp();
      } else {
        inputStartTimestamp = params.getInputStartTimestamp();
      }
      long inputStart = inputStartTimestamp;
      RecordHistogram.recordTimesHistogram(
          "Android.Omnibox.InputToNavigationControllerStart",
          SystemClock.uptimeMillis() - inputStart);
      Natives natives = NavigationControllerImplJni.get();
      long j = this.mNativeNavigationControllerAndroid;
      String url = params.getUrl();
      int loadUrlType = params.getLoadUrlType();
      int transitionType = params.getTransitionType();
      if (params.getReferrer() != null) {
        str = params.getReferrer().getUrl();
      } else {
        str = null;
      }
      if (params.getReferrer() != null) {
        i = params.getReferrer().getPolicy();
      } else {
        i = 0;
      }
      int userAgentOverrideOption = params.getUserAgentOverrideOption();
      ResourceRequestBody postData = params.getPostData();
      String baseUrl = params.getBaseUrl();
      String virtualUrlForDataUrl = params.getVirtualUrlForDataUrl();
      String dataUrlAsString = params.getDataUrlAsString();
      boolean canLoadLocalResources = params.getCanLoadLocalResources();
      boolean isRendererInitiated = params.getIsRendererInitiated();
      boolean shouldReplaceCurrentEntry = params.getShouldReplaceCurrentEntry();
      Origin initiatorOrigin = params.getInitiatorOrigin();
      boolean hasUserGesture = params.getHasUserGesture();
      boolean shouldClearHistoryList = params.getShouldClearHistoryList();
      AdditionalNavigationParams additionalNavigationParams =
          params.getAdditionalNavigationParams();
      if (params.getNavigationUIDataSupplier() == null) {
        longValue = 0;
      } else {
        longValue = params.getNavigationUIDataSupplier().get().longValue();
      }
      NavigationHandle navigationHandle =
          natives.loadUrl(
              j,
              this,
              url,
              loadUrlType,
              transitionType,
              str,
              i,
              userAgentOverrideOption,
              headers,
              postData,
              baseUrl,
              virtualUrlForDataUrl,
              dataUrlAsString,
              canLoadLocalResources,
              isRendererInitiated,
              shouldReplaceCurrentEntry,
              initiatorOrigin,
              hasUserGesture,
              shouldClearHistoryList,
              additionalNavigationParams,
              inputStart,
              longValue,
              params.getIsPdf());
      if (navigationHandle != null) {
        navigationHandle.setUserDataHost(params.takeNavigationHandleUserData());
      }
      return navigationHandle;
    }
    return null;
  }

  @Override
  public void clearHistory() {
    if (this.mNativeNavigationControllerAndroid != 0) {
      NavigationControllerImplJni.get().clearHistory(this.mNativeNavigationControllerAndroid, this);
    }
  }

  @Override
  public NavigationHistory getNavigationHistory() {
    if (this.mNativeNavigationControllerAndroid == 0) {
      return null;
    }
    NavigationHistory history = new NavigationHistory();
    int currentIndex =
        NavigationControllerImplJni.get()
            .getNavigationHistory(this.mNativeNavigationControllerAndroid, this, history);
    history.setCurrentEntryIndex(currentIndex);
    return history;
  }

  @Override
  public NavigationHistory getDirectedNavigationHistory(boolean isForward, int itemLimit) {
    if (this.mNativeNavigationControllerAndroid == 0) {
      return null;
    }
    NavigationHistory history = new NavigationHistory();
    NavigationControllerImplJni.get()
        .getDirectedNavigationHistory(
            this.mNativeNavigationControllerAndroid, this, history, isForward, itemLimit);
    return history;
  }

  @Override
  public void clearSslPreferences() {
    if (this.mNativeNavigationControllerAndroid != 0) {
      NavigationControllerImplJni.get()
          .clearSslPreferences(this.mNativeNavigationControllerAndroid, this);
    }
  }

  @Override
  public boolean getUseDesktopUserAgent() {
    if (this.mNativeNavigationControllerAndroid == 0) {
      return false;
    }
    return NavigationControllerImplJni.get()
        .getUseDesktopUserAgent(this.mNativeNavigationControllerAndroid, this);
  }

  @Override
  public void setUseDesktopUserAgent(boolean override, boolean reloadOnChange, int caller) {
    if (this.mNativeNavigationControllerAndroid != 0) {
      Log.i(
          TAG,
          "Thread dump for debugging, override: "
              + override
              + " reloadOnChange: "
              + reloadOnChange
              + " caller: "
              + caller);
      Thread.dumpStack();
      NavigationControllerImplJni.get()
          .setUseDesktopUserAgent(
              this.mNativeNavigationControllerAndroid, this, override, reloadOnChange, caller);
    }
  }

  @Override
  public NavigationEntry getEntryAtIndex(int index) {
    if (this.mNativeNavigationControllerAndroid != 0) {
      return NavigationControllerImplJni.get()
          .getEntryAtIndex(this.mNativeNavigationControllerAndroid, this, index);
    }
    return null;
  }

  @Override
  public NavigationEntry getVisibleEntry() {
    if (this.mNativeNavigationControllerAndroid != 0) {
      return NavigationControllerImplJni.get()
          .getVisibleEntry(this.mNativeNavigationControllerAndroid, this);
    }
    return null;
  }

  @Override
  public NavigationEntry getPendingEntry() {
    if (this.mNativeNavigationControllerAndroid != 0) {
      return NavigationControllerImplJni.get()
          .getPendingEntry(this.mNativeNavigationControllerAndroid, this);
    }
    return null;
  }

  @Override
  public int getLastCommittedEntryIndex() {
    if (this.mNativeNavigationControllerAndroid != 0) {
      return NavigationControllerImplJni.get()
          .getLastCommittedEntryIndex(this.mNativeNavigationControllerAndroid, this);
    }
    return -1;
  }

  @Override
  public boolean removeEntryAtIndex(int index) {
    if (this.mNativeNavigationControllerAndroid != 0) {
      return NavigationControllerImplJni.get()
          .removeEntryAtIndex(this.mNativeNavigationControllerAndroid, this, index);
    }
    return false;
  }

  @Override
  public void pruneForwardEntries() {
    if (this.mNativeNavigationControllerAndroid == 0) {
      return;
    }
    NavigationControllerImplJni.get()
        .pruneForwardEntries(this.mNativeNavigationControllerAndroid, this);
  }

  @Override
  public String getEntryExtraData(int index, String key) {
    if (this.mNativeNavigationControllerAndroid == 0) {
      return null;
    }
    return NavigationControllerImplJni.get()
        .getEntryExtraData(this.mNativeNavigationControllerAndroid, this, index, key);
  }

  @Override
  public void setEntryExtraData(int index, String key, String value) {
    if (this.mNativeNavigationControllerAndroid == 0) {
      return;
    }
    NavigationControllerImplJni.get()
        .setEntryExtraData(this.mNativeNavigationControllerAndroid, this, index, key, value);
  }

  private static void addToNavigationHistory(Object history, Object navigationEntry) {
    ((NavigationHistory) history).addEntry((NavigationEntry) navigationEntry);
  }

  private static NavigationEntry createNavigationEntry(
      int index,
      GURL url,
      GURL virtualUrl,
      GURL originalUrl,
      String title,
      Bitmap favicon,
      int transition,
      long timestamp,
      boolean isInitialEntry) {
    return new NavigationEntry(
        index, url, virtualUrl, originalUrl, title, favicon, transition, timestamp, isInitialEntry);
  }
}
