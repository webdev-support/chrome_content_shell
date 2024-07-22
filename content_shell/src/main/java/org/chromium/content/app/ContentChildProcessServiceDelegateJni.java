package org.chromium.content.app;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ContentChildProcessServiceDelegateJni
    implements ContentChildProcessServiceDelegate.Natives {
  public static final JniStaticTestMocker<ContentChildProcessServiceDelegate.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ContentChildProcessServiceDelegate.Natives>() {
        @Override
        public void setInstanceForTesting(ContentChildProcessServiceDelegate.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ContentChildProcessServiceDelegateJni.testInstance = instance;
        }
      };
  private static ContentChildProcessServiceDelegate.Natives testInstance;

  ContentChildProcessServiceDelegateJni() {}

  @Override
  public void initChildProcess(
      ContentChildProcessServiceDelegate caller, int cpuCount, long cpuFeatures) {
    GEN_JNI.org_chromium_content_app_ContentChildProcessServiceDelegate_initChildProcess(
        caller, cpuCount, cpuFeatures);
  }

  @Override
  public void initMemoryPressureListener() {
    GEN_JNI
        .org_chromium_content_app_ContentChildProcessServiceDelegate_initMemoryPressureListener();
  }

  @Override
  public void retrieveFileDescriptorsIdsToKeys(ContentChildProcessServiceDelegate caller) {
    GEN_JNI
        .org_chromium_content_app_ContentChildProcessServiceDelegate_retrieveFileDescriptorsIdsToKeys(
            caller);
  }

  public static ContentChildProcessServiceDelegate.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ContentChildProcessServiceDelegate.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ContentChildProcessServiceDelegate.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ContentChildProcessServiceDelegateJni();
  }
}
