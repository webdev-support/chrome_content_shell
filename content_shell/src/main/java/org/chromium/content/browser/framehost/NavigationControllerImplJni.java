package org.chromium.content.browser.framehost;

import org.chromium.content_public.browser.AdditionalNavigationParams;
import org.chromium.content_public.browser.NavigationEntry;
import org.chromium.content_public.browser.NavigationHandle;
import org.chromium.content_public.browser.NavigationHistory;
import org.chromium.content_public.common.ResourceRequestBody;
import org.chromium.url.Origin;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class NavigationControllerImplJni implements NavigationControllerImpl.Natives {

  public static final JniStaticTestMocker<NavigationControllerImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<NavigationControllerImpl.Natives>() {
        @Override
        public void setInstanceForTesting(NavigationControllerImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          NavigationControllerImplJni.testInstance = instance;
        }
      };
  private static NavigationControllerImpl.Natives testInstance;

  NavigationControllerImplJni() {}

  @Override
  public boolean canGoBack(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_canGoBack(
        nativeNavigationControllerAndroid, caller);
  }

  @Override
  public boolean canGoForward(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_canGoForward(
        nativeNavigationControllerAndroid, caller);
  }

  @Override
  public boolean canGoToOffset(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller, int offset) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_canGoToOffset(
        nativeNavigationControllerAndroid, caller, offset);
  }

  @Override
  public void cancelPendingReload(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_cancelPendingReload(
        nativeNavigationControllerAndroid, caller);
  }

  @Override
  public void clearHistory(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_clearHistory(
        nativeNavigationControllerAndroid, caller);
  }

  @Override
  public void clearSslPreferences(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_clearSslPreferences(
        nativeNavigationControllerAndroid, caller);
  }

  @Override
  public void continuePendingReload(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_continuePendingReload(
        nativeNavigationControllerAndroid, caller);
  }

  @Override
  public void getDirectedNavigationHistory(
      long nativeNavigationControllerAndroid,
      NavigationControllerImpl caller,
      NavigationHistory history,
      boolean isForward,
      int itemLimit) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_framehost_NavigationControllerImpl_getDirectedNavigationHistory(
            nativeNavigationControllerAndroid, caller, history, isForward, itemLimit);
  }

  @Override
  public NavigationEntry getEntryAtIndex(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller, int index) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    return (NavigationEntry)
        GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_getEntryAtIndex(
            nativeNavigationControllerAndroid, caller, index);
  }

  @Override
  public String getEntryExtraData(
      long nativeNavigationControllerAndroid,
      NavigationControllerImpl caller,
      int index,
      String key) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_framehost_NavigationControllerImpl_getEntryExtraData(
            nativeNavigationControllerAndroid, caller, index, key);
  }

  @Override
  public int getLastCommittedEntryIndex(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_framehost_NavigationControllerImpl_getLastCommittedEntryIndex(
            nativeNavigationControllerAndroid, caller);
  }

  @Override
  public int getNavigationHistory(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller, Object history) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_framehost_NavigationControllerImpl_getNavigationHistory(
            nativeNavigationControllerAndroid, caller, history);
  }

  @Override
  public NavigationEntry getPendingEntry(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    return (NavigationEntry)
        GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_getPendingEntry(
            nativeNavigationControllerAndroid, caller);
  }

  @Override
  public boolean getUseDesktopUserAgent(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_framehost_NavigationControllerImpl_getUseDesktopUserAgent(
            nativeNavigationControllerAndroid, caller);
  }

  @Override
  public NavigationEntry getVisibleEntry(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    return (NavigationEntry)
        GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_getVisibleEntry(
            nativeNavigationControllerAndroid, caller);
  }

  @Override
  public void goBack(long nativeNavigationControllerAndroid, NavigationControllerImpl caller) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_goBack(
        nativeNavigationControllerAndroid, caller);
  }

  @Override
  public void goForward(long nativeNavigationControllerAndroid, NavigationControllerImpl caller) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_goForward(
        nativeNavigationControllerAndroid, caller);
  }

  @Override
  public void goToNavigationIndex(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller, int index) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_goToNavigationIndex(
        nativeNavigationControllerAndroid, caller, index);
  }

  @Override
  public void goToOffset(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller, int offset) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_goToOffset(
        nativeNavigationControllerAndroid, caller, offset);
  }

  @Override
  public boolean isInitialNavigation(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_framehost_NavigationControllerImpl_isInitialNavigation(
            nativeNavigationControllerAndroid, caller);
  }

  @Override
  public void loadIfNecessary(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_loadIfNecessary(
        nativeNavigationControllerAndroid, caller);
  }

  @Override
  public NavigationHandle loadUrl(
      long nativeNavigationControllerAndroid,
      NavigationControllerImpl caller,
      String url,
      int loadUrlType,
      int transitionType,
      String referrerUrl,
      int referrerPolicy,
      int uaOverrideOption,
      String extraHeaders,
      ResourceRequestBody postData,
      String baseUrlForDataUrl,
      String virtualUrlForDataUrl,
      String dataUrlAsString,
      boolean canLoadLocalResources,
      boolean isRendererInitiated,
      boolean shouldReplaceCurrentEntry,
      Origin initiatorOrigin,
      boolean hasUserGesture,
      boolean shouldClearHistoryList,
      AdditionalNavigationParams additionalNavigationParams,
      long inputStart,
      long navigationUIDataPtr,
      boolean isPdf) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    return (NavigationHandle)
        GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_loadUrl(
            nativeNavigationControllerAndroid,
            caller,
            url,
            loadUrlType,
            transitionType,
            referrerUrl,
            referrerPolicy,
            uaOverrideOption,
            extraHeaders,
            postData,
            baseUrlForDataUrl,
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
            navigationUIDataPtr,
            isPdf);
  }

  @Override
  public boolean needsReload(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_needsReload(
        nativeNavigationControllerAndroid, caller);
  }

  @Override
  public void pruneForwardEntries(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_pruneForwardEntries(
        nativeNavigationControllerAndroid, caller);
  }

  @Override
  public void reload(
      long nativeNavigationControllerAndroid,
      NavigationControllerImpl caller,
      boolean checkForRepost) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_reload(
        nativeNavigationControllerAndroid, caller, checkForRepost);
  }

  @Override
  public void reloadBypassingCache(
      long nativeNavigationControllerAndroid,
      NavigationControllerImpl caller,
      boolean checkForRepost) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_reloadBypassingCache(
        nativeNavigationControllerAndroid, caller, checkForRepost);
  }

  @Override
  public boolean removeEntryAtIndex(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller, int index) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_framehost_NavigationControllerImpl_removeEntryAtIndex(
            nativeNavigationControllerAndroid, caller, index);
  }

  @Override
  public void setEntryExtraData(
      long nativeNavigationControllerAndroid,
      NavigationControllerImpl caller,
      int index,
      String key,
      String value) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_setEntryExtraData(
        nativeNavigationControllerAndroid, caller, index, key, value);
  }

  @Override
  public void setNeedsReload(
      long nativeNavigationControllerAndroid, NavigationControllerImpl caller) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_setNeedsReload(
        nativeNavigationControllerAndroid, caller);
  }

  @Override
  public void setUseDesktopUserAgent(
      long nativeNavigationControllerAndroid,
      NavigationControllerImpl caller,
      boolean override,
      boolean reloadOnChange,
      int source) {
    if (nativeNavigationControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_NavigationControllerImpl_setUseDesktopUserAgent(
        nativeNavigationControllerAndroid, caller, override, reloadOnChange, source);
  }

  public static NavigationControllerImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      NavigationControllerImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of NavigationControllerImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new NavigationControllerImplJni();
  }
}
