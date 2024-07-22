package org.chromium.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class MemoryPressureListenerJni implements MemoryPressureListener.Natives {
  public static final JniStaticTestMocker<MemoryPressureListener.Natives> TEST_HOOKS =
      new JniStaticTestMocker<MemoryPressureListener.Natives>() {
        @Override
        public void setInstanceForTesting(MemoryPressureListener.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          MemoryPressureListenerJni.testInstance = instance;
        }
      };
  private static MemoryPressureListener.Natives testInstance;

  MemoryPressureListenerJni() {}

  @Override
  public void onMemoryPressure(int pressure) {
    GEN_JNI.org_chromium_base_MemoryPressureListener_onMemoryPressure(pressure);
  }

  @Override
  public void onPreFreeze() {
    GEN_JNI.org_chromium_base_MemoryPressureListener_onPreFreeze();
  }

  public static MemoryPressureListener.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      MemoryPressureListener.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of MemoryPressureListener.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new MemoryPressureListenerJni();
  }
}
