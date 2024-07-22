package org.chromium.components.crash.anr;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class AnrCollectorJni implements AnrCollector.Natives {
  public static final JniStaticTestMocker<AnrCollector.Natives> TEST_HOOKS =
      new JniStaticTestMocker<AnrCollector.Natives>() {
        @Override
        public void setInstanceForTesting(AnrCollector.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          AnrCollectorJni.testInstance = instance;
        }
      };
  private static AnrCollector.Natives testInstance;

  AnrCollectorJni() {}

  @Override
  public String getSharedLibraryBuildId() {
    return GEN_JNI.org_chromium_components_crash_anr_AnrCollector_getSharedLibraryBuildId();
  }

  public static AnrCollector.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      AnrCollector.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of AnrCollector.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new AnrCollectorJni();
  }
}
