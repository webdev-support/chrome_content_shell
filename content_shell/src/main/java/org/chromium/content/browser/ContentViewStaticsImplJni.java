package org.chromium.content.browser;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ContentViewStaticsImplJni implements ContentViewStaticsImpl.Natives {
  public static final JniStaticTestMocker<ContentViewStaticsImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ContentViewStaticsImpl.Natives>() {
        @Override
        public void setInstanceForTesting(ContentViewStaticsImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ContentViewStaticsImplJni.testInstance = instance;
        }
      };
  private static ContentViewStaticsImpl.Natives testInstance;

  ContentViewStaticsImplJni() {}

  @Override
  public void setWebKitSharedTimersSuspended(boolean suspend) {
    GEN_JNI.org_chromium_content_browser_ContentViewStaticsImpl_setWebKitSharedTimersSuspended(
        suspend);
  }

  public static ContentViewStaticsImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ContentViewStaticsImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ContentViewStaticsImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ContentViewStaticsImplJni();
  }
}
