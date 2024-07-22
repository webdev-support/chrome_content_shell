package org.chromium.content.browser;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class BrowserStartupControllerImplJni implements BrowserStartupControllerImpl.Natives {
  public static final JniStaticTestMocker<BrowserStartupControllerImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<BrowserStartupControllerImpl.Natives>() {
        @Override
        public void setInstanceForTesting(BrowserStartupControllerImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          BrowserStartupControllerImplJni.testInstance = instance;
        }
      };
  private static BrowserStartupControllerImpl.Natives testInstance;

  BrowserStartupControllerImplJni() {}

  @Override
  public void flushStartupTasks() {
    GEN_JNI.org_chromium_content_browser_BrowserStartupControllerImpl_flushStartupTasks();
  }

  @Override
  public void setCommandLineFlags(boolean singleProcess) {
    GEN_JNI.org_chromium_content_browser_BrowserStartupControllerImpl_setCommandLineFlags(
        singleProcess);
  }

  public static BrowserStartupControllerImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      BrowserStartupControllerImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of BrowserStartupControllerImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new BrowserStartupControllerImplJni();
  }
}
