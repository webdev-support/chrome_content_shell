package org.chromium.content_public.browser;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ContentFeatureMapJni implements ContentFeatureMap.Natives {
  public static final JniStaticTestMocker<ContentFeatureMap.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ContentFeatureMap.Natives>() {
        @Override
        public void setInstanceForTesting(ContentFeatureMap.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ContentFeatureMapJni.testInstance = instance;
        }
      };
  private static ContentFeatureMap.Natives testInstance;

  @Override
  public long getNativeMap() {
    return GEN_JNI.org_chromium_content_1public_browser_ContentFeatureMap_getNativeMap();
  }

  public static ContentFeatureMap.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ContentFeatureMap.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ContentFeatureMap.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ContentFeatureMapJni();
  }
}
