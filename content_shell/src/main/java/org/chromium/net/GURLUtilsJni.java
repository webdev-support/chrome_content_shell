package org.chromium.net;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class GURLUtilsJni implements GURLUtils.Natives {
  public static final JniStaticTestMocker<GURLUtils.Natives> TEST_HOOKS =
      new JniStaticTestMocker<GURLUtils.Natives>() {
        @Override
        public void setInstanceForTesting(GURLUtils.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          GURLUtilsJni.testInstance = instance;
        }
      };
  private static GURLUtils.Natives testInstance;

  @Override
  public String getOrigin(String url) {
    return GEN_JNI.org_chromium_net_GURLUtils_getOrigin(url);
  }

  public static GURLUtils.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      GURLUtils.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of GURLUtils.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new GURLUtilsJni();
  }
}
