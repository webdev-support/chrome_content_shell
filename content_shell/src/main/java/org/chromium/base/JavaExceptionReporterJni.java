package org.chromium.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class JavaExceptionReporterJni implements JavaExceptionReporter.Natives {
  public static final JniStaticTestMocker<JavaExceptionReporter.Natives> TEST_HOOKS =
      new JniStaticTestMocker<JavaExceptionReporter.Natives>() {
        @Override
        public void setInstanceForTesting(JavaExceptionReporter.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          JavaExceptionReporterJni.testInstance = instance;
        }
      };
  private static JavaExceptionReporter.Natives testInstance;

  JavaExceptionReporterJni() {}

  @Override
  public void reportJavaException(boolean crashAfterReport, Throwable e) {
    GEN_JNI.org_chromium_base_JavaExceptionReporter_reportJavaException(crashAfterReport, e);
  }

  @Override
  public void reportJavaStackTrace(String stackTrace) {
    GEN_JNI.org_chromium_base_JavaExceptionReporter_reportJavaStackTrace(stackTrace);
  }

  public static JavaExceptionReporter.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      JavaExceptionReporter.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of JavaExceptionReporter.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new JavaExceptionReporterJni();
  }
}
