package org.chromium.components.variations;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class VariationsAssociatedDataJni implements VariationsAssociatedData.Natives {
  public static final JniStaticTestMocker<VariationsAssociatedData.Natives> TEST_HOOKS =
      new JniStaticTestMocker<VariationsAssociatedData.Natives>() {
        @Override
        public void setInstanceForTesting(VariationsAssociatedData.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          VariationsAssociatedDataJni.testInstance = instance;
        }
      };
  private static VariationsAssociatedData.Natives testInstance;

  VariationsAssociatedDataJni() {}

  @Override
  public String getFeedbackVariations() {
    return GEN_JNI
        .org_chromium_components_variations_VariationsAssociatedData_getFeedbackVariations();
  }

  @Override
  public String getGoogleAppVariations() {
    return GEN_JNI
        .org_chromium_components_variations_VariationsAssociatedData_getGoogleAppVariations();
  }

  @Override
  public String getVariationParamValue(String trialName, String paramName) {
    return GEN_JNI
        .org_chromium_components_variations_VariationsAssociatedData_getVariationParamValue(
            trialName, paramName);
  }

  public static VariationsAssociatedData.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      VariationsAssociatedData.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of VariationsAssociatedData.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new VariationsAssociatedDataJni();
  }
}
