package org.chromium.content.browser;

import org.chromium.content_public.browser.BrowserContextHandle;
import org.chromium.content_public.browser.SiteZoomInfo;
import org.chromium.content_public.browser.WebContents;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class HostZoomMapImplJni implements HostZoomMapImpl.Natives {
  public static final JniStaticTestMocker<HostZoomMapImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<HostZoomMapImpl.Natives>() {
        @Override
        public void setInstanceForTesting(HostZoomMapImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          HostZoomMapImplJni.testInstance = instance;
        }
      };
  private static HostZoomMapImpl.Natives testInstance;

  @Override
  public SiteZoomInfo[] getAllHostZoomLevels(BrowserContextHandle context) {
    return (SiteZoomInfo[])
        GEN_JNI.org_chromium_content_browser_HostZoomMapImpl_getAllHostZoomLevels(context);
  }

  @Override
  public double getDefaultZoomLevel(BrowserContextHandle context) {
    return GEN_JNI.org_chromium_content_browser_HostZoomMapImpl_getDefaultZoomLevel(context);
  }

  @Override
  public double getZoomLevel(WebContents webContents) {
    return GEN_JNI.org_chromium_content_browser_HostZoomMapImpl_getZoomLevel(webContents);
  }

  @Override
  public void setDefaultZoomLevel(BrowserContextHandle context, double newDefaultZoomLevel) {
    GEN_JNI.org_chromium_content_browser_HostZoomMapImpl_setDefaultZoomLevel(
        context, newDefaultZoomLevel);
  }

  @Override
  public void setZoomLevel(WebContents webContents, double newZoomLevel, double adjustedZoomLevel) {
    GEN_JNI.org_chromium_content_browser_HostZoomMapImpl_setZoomLevel(
        webContents, newZoomLevel, adjustedZoomLevel);
  }

  @Override
  public void setZoomLevelForHost(BrowserContextHandle context, String host, double level) {
    GEN_JNI.org_chromium_content_browser_HostZoomMapImpl_setZoomLevelForHost(context, host, level);
  }

  public static HostZoomMapImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      HostZoomMapImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of HostZoomMapImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new HostZoomMapImplJni();
  }
}
