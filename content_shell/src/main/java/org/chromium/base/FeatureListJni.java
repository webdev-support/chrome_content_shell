package org.chromium.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class FeatureListJni implements FeatureList.Natives {
  public static final JniStaticTestMocker<FeatureList.Natives> TEST_HOOKS =
      new JniStaticTestMocker<FeatureList.Natives>() {
        @Override
        public void setInstanceForTesting(FeatureList.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          FeatureListJni.testInstance = instance;
        }
      };
  private static FeatureList.Natives testInstance;

  @Override
  public boolean isInitialized() {
    return GEN_JNI.org_chromium_base_FeatureList_isInitialized();
  }

  public static FeatureList.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      FeatureList.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of FeatureList.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new FeatureListJni();
  }
}
