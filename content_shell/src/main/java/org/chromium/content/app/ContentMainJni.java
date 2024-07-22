package org.chromium.content.app;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ContentMainJni implements ContentMain.Natives {
  public static final JniStaticTestMocker<ContentMain.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ContentMain.Natives>() {
        @Override
        public void setInstanceForTesting(ContentMain.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ContentMainJni.testInstance = instance;
        }
      };
  private static ContentMain.Natives testInstance;

  ContentMainJni() {}

  @Override
  public int start(boolean startMinimalBrowser) {
    return GEN_JNI.org_chromium_content_app_ContentMain_start(startMinimalBrowser);
  }

  public static ContentMain.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ContentMain.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ContentMain.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ContentMainJni();
  }
}
