package org.chromium.base.library_loader;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class LibraryLoaderJni implements LibraryLoader.Natives {
  public static final JniStaticTestMocker<LibraryLoader.Natives> TEST_HOOKS =
      new JniStaticTestMocker<LibraryLoader.Natives>() {
        @Override
        public void setInstanceForTesting(LibraryLoader.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          LibraryLoaderJni.testInstance = instance;
        }
      };
  private static LibraryLoader.Natives testInstance;

  LibraryLoaderJni() {}

  @Override
  public boolean libraryLoaded(int processType) {
    return GEN_JNI.org_chromium_base_library_1loader_LibraryLoader_libraryLoaded(processType);
  }

  public static LibraryLoader.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      LibraryLoader.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of LibraryLoader.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new LibraryLoaderJni();
  }
}
