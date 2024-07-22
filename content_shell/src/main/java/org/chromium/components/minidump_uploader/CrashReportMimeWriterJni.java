package org.chromium.components.minidump_uploader;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class CrashReportMimeWriterJni implements CrashReportMimeWriter.Natives {
  public static final JniStaticTestMocker<CrashReportMimeWriter.Natives> TEST_HOOKS =
      new JniStaticTestMocker<CrashReportMimeWriter.Natives>() {
        @Override
        public void setInstanceForTesting(CrashReportMimeWriter.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          CrashReportMimeWriterJni.testInstance = instance;
        }
      };
  private static CrashReportMimeWriter.Natives testInstance;

  CrashReportMimeWriterJni() {}

  @Override
  public void rewriteAnrsAsMIMEs(String[] anrs, String destDir) {
    GEN_JNI.org_chromium_components_minidump_1uploader_CrashReportMimeWriter_rewriteAnrsAsMIMEs(
        anrs, destDir);
  }

  @Override
  public void rewriteMinidumpsAsMIMEs(String srcDir, String destDir) {
    GEN_JNI
        .org_chromium_components_minidump_1uploader_CrashReportMimeWriter_rewriteMinidumpsAsMIMEs(
            srcDir, destDir);
  }

  @Override
  public String[] rewriteMinidumpsAsMIMEsAndGetCrashKeys(String srcDir, String destDir) {
    throw new RuntimeException("Stub not implemented");
  }

  public static CrashReportMimeWriter.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      CrashReportMimeWriter.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of CrashReportMimeWriter.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new CrashReportMimeWriterJni();
  }
}
