package org.chromium.content.browser;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class BackgroundSyncNetworkObserverJni implements BackgroundSyncNetworkObserver.Natives {

  public static final JniStaticTestMocker<BackgroundSyncNetworkObserver.Natives> TEST_HOOKS =
      new JniStaticTestMocker<BackgroundSyncNetworkObserver.Natives>() {
        @Override
        public void setInstanceForTesting(BackgroundSyncNetworkObserver.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          BackgroundSyncNetworkObserverJni.testInstance = instance;
        }
      };
  private static BackgroundSyncNetworkObserver.Natives testInstance;

  BackgroundSyncNetworkObserverJni() {}

  @Override
  public void notifyConnectionTypeChanged(
      long nativePtr, BackgroundSyncNetworkObserver caller, int newConnectionType) {
    if (nativePtr == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_BackgroundSyncNetworkObserver_notifyConnectionTypeChanged(
        nativePtr, caller, newConnectionType);
  }

  public static BackgroundSyncNetworkObserver.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      BackgroundSyncNetworkObserver.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of BackgroundSyncNetworkObserver.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new BackgroundSyncNetworkObserverJni();
  }
}
