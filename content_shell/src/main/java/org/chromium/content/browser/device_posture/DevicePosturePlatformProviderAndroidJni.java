package org.chromium.content.browser.device_posture;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class DevicePosturePlatformProviderAndroidJni
    implements DevicePosturePlatformProviderAndroid.Natives {

  public static final JniStaticTestMocker<DevicePosturePlatformProviderAndroid.Natives> TEST_HOOKS =
      new JniStaticTestMocker<DevicePosturePlatformProviderAndroid.Natives>() {
        @Override
        public void setInstanceForTesting(DevicePosturePlatformProviderAndroid.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          DevicePosturePlatformProviderAndroidJni.testInstance = instance;
        }
      };
  private static DevicePosturePlatformProviderAndroid.Natives testInstance;

  DevicePosturePlatformProviderAndroidJni() {}

  @Override
  public void updateDisplayFeature(
      long nativeDevicePosturePlatformProviderAndroid,
      boolean isFolded,
      int displayFeatureBoundsLeft,
      int displayFeatureBoundsTop,
      int displayFeatureBoundsRight,
      int displayFeatureBoundsBottom) {
    if (nativeDevicePosturePlatformProviderAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_device_1posture_DevicePosturePlatformProviderAndroid_updateDisplayFeature(
            nativeDevicePosturePlatformProviderAndroid,
            isFolded,
            displayFeatureBoundsLeft,
            displayFeatureBoundsTop,
            displayFeatureBoundsRight,
            displayFeatureBoundsBottom);
  }

  public static DevicePosturePlatformProviderAndroid.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      DevicePosturePlatformProviderAndroid.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of DevicePosturePlatformProviderAndroid.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new DevicePosturePlatformProviderAndroidJni();
  }
}
