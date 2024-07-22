package org.chromium.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class CpuFeaturesJni implements CpuFeatures.Natives {
  public static final JniStaticTestMocker<CpuFeatures.Natives> TEST_HOOKS =
      instance -> {
        if (!GEN_JNI.TESTING_ENABLED) {
          throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
        CpuFeaturesJni.testInstance = instance;
      };
  private static CpuFeatures.Natives testInstance;

  CpuFeaturesJni() {}

  @Override
  public int getCoreCount() {
    return GEN_JNI.org_chromium_base_CpuFeatures_getCoreCount();
  }

  @Override
  public long getCpuFeatures() {
    return GEN_JNI.org_chromium_base_CpuFeatures_getCpuFeatures();
  }

  public static CpuFeatures.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      CpuFeatures.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of CpuFeatures.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new CpuFeaturesJni();
  }
}
