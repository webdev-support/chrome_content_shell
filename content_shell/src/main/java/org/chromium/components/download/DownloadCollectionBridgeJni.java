package org.chromium.components.download;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class DownloadCollectionBridgeJni implements DownloadCollectionBridge.Natives {
  public static final JniStaticTestMocker<DownloadCollectionBridge.Natives> TEST_HOOKS =
      new JniStaticTestMocker<DownloadCollectionBridge.Natives>() {
        @Override
        public void setInstanceForTesting(DownloadCollectionBridge.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          DownloadCollectionBridgeJni.testInstance = instance;
        }
      };
  private static DownloadCollectionBridge.Natives testInstance;

  DownloadCollectionBridgeJni() {}

  @Override
  public int getExpirationDurationInDays() {
    return (int)
        GEN_JNI
            .org_chromium_components_download_DownloadCollectionBridge_getExpirationDurationInDays();
  }

  public static DownloadCollectionBridge.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      DownloadCollectionBridge.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of DownloadCollectionBridge.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new DownloadCollectionBridgeJni();
  }
}
