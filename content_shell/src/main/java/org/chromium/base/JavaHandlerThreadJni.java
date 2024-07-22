package org.chromium.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class JavaHandlerThreadJni implements JavaHandlerThread.Natives {

  public static final JniStaticTestMocker<JavaHandlerThread.Natives> TEST_HOOKS =
      new JniStaticTestMocker<JavaHandlerThread.Natives>() {
        @Override
        public void setInstanceForTesting(JavaHandlerThread.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          JavaHandlerThreadJni.testInstance = instance;
        }
      };
  private static JavaHandlerThread.Natives testInstance;

  JavaHandlerThreadJni() {}

  @Override
  public void initializeThread(long nativeJavaHandlerThread, long nativeEvent) {
    if (nativeJavaHandlerThread == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_base_JavaHandlerThread_initializeThread(
        nativeJavaHandlerThread, nativeEvent);
  }

  @Override
  public void onLooperStopped(long nativeJavaHandlerThread) {
    if (nativeJavaHandlerThread == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_base_JavaHandlerThread_onLooperStopped(nativeJavaHandlerThread);
  }

  public static JavaHandlerThread.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      JavaHandlerThread.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of JavaHandlerThread.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new JavaHandlerThreadJni();
  }
}
