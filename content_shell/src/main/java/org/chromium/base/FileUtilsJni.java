package org.chromium.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class FileUtilsJni implements FileUtils.Natives {
  public static final JniStaticTestMocker<FileUtils.Natives> TEST_HOOKS =
      new JniStaticTestMocker<FileUtils.Natives>() {
        @Override
        public void setInstanceForTesting(FileUtils.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          FileUtilsJni.testInstance = instance;
        }
      };
  private static FileUtils.Natives testInstance;

  @Override
  public String getAbsoluteFilePath(String filePath) {
    return GEN_JNI.org_chromium_base_FileUtils_getAbsoluteFilePath(filePath);
  }

  public static FileUtils.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      FileUtils.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of FileUtils.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new FileUtilsJni();
  }
}
