package org.chromium.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ImportantFileWriterAndroidJni implements ImportantFileWriterAndroid.Natives {
  public static final JniStaticTestMocker<ImportantFileWriterAndroid.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ImportantFileWriterAndroid.Natives>() {
        @Override
        public void setInstanceForTesting(ImportantFileWriterAndroid.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ImportantFileWriterAndroidJni.testInstance = instance;
        }
      };
  private static ImportantFileWriterAndroid.Natives testInstance;

  ImportantFileWriterAndroidJni() {}

  @Override
  public boolean writeFileAtomically(String fileName, byte[] data) {
    return GEN_JNI.org_chromium_base_ImportantFileWriterAndroid_writeFileAtomically(fileName, data);
  }

  public static ImportantFileWriterAndroid.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ImportantFileWriterAndroid.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ImportantFileWriterAndroid.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ImportantFileWriterAndroidJni();
  }
}
