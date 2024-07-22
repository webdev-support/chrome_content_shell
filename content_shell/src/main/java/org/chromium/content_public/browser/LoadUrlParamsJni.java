package org.chromium.content_public.browser;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class LoadUrlParamsJni implements LoadUrlParams.Natives {
  public static final JniStaticTestMocker<LoadUrlParams.Natives> TEST_HOOKS =
      new JniStaticTestMocker<LoadUrlParams.Natives>() {
        @Override
        public void setInstanceForTesting(LoadUrlParams.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          LoadUrlParamsJni.testInstance = instance;
        }
      };
  private static LoadUrlParams.Natives testInstance;

  LoadUrlParamsJni() {}

  @Override
  public boolean isDataScheme(String url) {
    return GEN_JNI.org_chromium_content_1public_browser_LoadUrlParams_isDataScheme(url);
  }

  public static LoadUrlParams.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      LoadUrlParams.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of LoadUrlParams.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new LoadUrlParamsJni();
  }
}
