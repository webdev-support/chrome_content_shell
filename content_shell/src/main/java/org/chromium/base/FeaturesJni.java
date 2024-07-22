package org.chromium.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class FeaturesJni implements Features.Natives {
  public static final JniStaticTestMocker<Features.Natives> TEST_HOOKS =
      new JniStaticTestMocker<Features.Natives>() {
        @Override
        public void setInstanceForTesting(Features.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          FeaturesJni.testInstance = instance;
        }
      };
  private static Features.Natives testInstance;

  FeaturesJni() {}

  @Override
  public boolean getFieldTrialParamByFeatureAsBoolean(
      long featurePointer, String paramName, boolean defaultValue) {
    return GEN_JNI.org_chromium_base_Features_getFieldTrialParamByFeatureAsBoolean(
        featurePointer, paramName, defaultValue);
  }

  @Override
  public String getFieldTrialParamByFeatureAsString(long featurePointer, String paramName) {
    return GEN_JNI.org_chromium_base_Features_getFieldTrialParamByFeatureAsString(
        featurePointer, paramName);
  }

  @Override
  public boolean isEnabled(long featurePointer) {
    return GEN_JNI.org_chromium_base_Features_isEnabled(featurePointer);
  }

  public static Features.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      Features.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of Features.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new FeaturesJni();
  }
}
