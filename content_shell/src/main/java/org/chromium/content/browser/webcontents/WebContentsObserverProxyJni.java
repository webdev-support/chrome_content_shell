package org.chromium.content.browser.webcontents;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class WebContentsObserverProxyJni implements WebContentsObserverProxy.Natives {

  public static final JniStaticTestMocker<WebContentsObserverProxy.Natives> TEST_HOOKS =
      new JniStaticTestMocker<WebContentsObserverProxy.Natives>() {
        @Override
        public void setInstanceForTesting(WebContentsObserverProxy.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          WebContentsObserverProxyJni.testInstance = instance;
        }
      };
  private static WebContentsObserverProxy.Natives testInstance;

  WebContentsObserverProxyJni() {}

  @Override
  public void destroy(long nativeWebContentsObserverProxy, WebContentsObserverProxy caller) {
    if (nativeWebContentsObserverProxy == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_webcontents_WebContentsObserverProxy_destroy(
        nativeWebContentsObserverProxy, caller);
  }

  @Override
  public long init(WebContentsObserverProxy caller, WebContentsImpl webContents) {
    return GEN_JNI.org_chromium_content_browser_webcontents_WebContentsObserverProxy_init(
        caller, webContents);
  }

  public static WebContentsObserverProxy.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      WebContentsObserverProxy.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of WebContentsObserverProxy.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new WebContentsObserverProxyJni();
  }
}
