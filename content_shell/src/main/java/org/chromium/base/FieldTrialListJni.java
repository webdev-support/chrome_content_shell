package org.chromium.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class FieldTrialListJni implements FieldTrialList.Natives {
  public static final JniStaticTestMocker<FieldTrialList.Natives> TEST_HOOKS =
      new JniStaticTestMocker<FieldTrialList.Natives>() {
        @Override
        public void setInstanceForTesting(FieldTrialList.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          FieldTrialListJni.testInstance = instance;
        }
      };
  private static FieldTrialList.Natives testInstance;

  FieldTrialListJni() {}

  @Override
  public boolean createFieldTrial(String trialName, String groupName) {
    return GEN_JNI.org_chromium_base_FieldTrialList_createFieldTrial(trialName, groupName);
  }

  @Override
  public String findFullName(String trialName) {
    return GEN_JNI.org_chromium_base_FieldTrialList_findFullName(trialName);
  }

  @Override
  public String getVariationParameter(String trialName, String parameterKey) {
    return GEN_JNI.org_chromium_base_FieldTrialList_getVariationParameter(trialName, parameterKey);
  }

  @Override
  public void logActiveTrials() {
    GEN_JNI.org_chromium_base_FieldTrialList_logActiveTrials();
  }

  @Override
  public boolean trialExists(String trialName) {
    return GEN_JNI.org_chromium_base_FieldTrialList_trialExists(trialName);
  }

  public static FieldTrialList.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      FieldTrialList.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of FieldTrialList.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new FieldTrialListJni();
  }
}
