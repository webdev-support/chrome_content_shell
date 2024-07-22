package org.chromium.base.library_loader;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class LibraryPrefetcherJni implements LibraryPrefetcher.Natives {
  public static final JniStaticTestMocker<LibraryPrefetcher.Natives> TEST_HOOKS =
      new JniStaticTestMocker<LibraryPrefetcher.Natives>() {
        @Override
        public void setInstanceForTesting(LibraryPrefetcher.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          LibraryPrefetcherJni.testInstance = instance;
        }
      };
  private static LibraryPrefetcher.Natives testInstance;

  LibraryPrefetcherJni() {}

  @Override
  public void forkAndPrefetchNativeLibrary() {
    GEN_JNI.org_chromium_base_library_1loader_LibraryPrefetcher_forkAndPrefetchNativeLibrary();
  }

  @Override
  public int percentageOfResidentNativeLibraryCode() {
    return GEN_JNI
        .org_chromium_base_library_1loader_LibraryPrefetcher_percentageOfResidentNativeLibraryCode();
  }

  @Override
  public void periodicallyCollectResidency() {
    GEN_JNI.org_chromium_base_library_1loader_LibraryPrefetcher_periodicallyCollectResidency();
  }

  public static LibraryPrefetcher.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      LibraryPrefetcher.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of LibraryPrefetcher.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new LibraryPrefetcherJni();
  }
}
