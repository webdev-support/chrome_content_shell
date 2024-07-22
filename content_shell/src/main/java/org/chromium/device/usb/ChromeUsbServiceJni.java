package org.chromium.device.usb;

import android.hardware.usb.UsbDevice;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ChromeUsbServiceJni implements ChromeUsbService.Natives {

  public static final JniStaticTestMocker<ChromeUsbService.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ChromeUsbService.Natives>() {
        @Override
        public void setInstanceForTesting(ChromeUsbService.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ChromeUsbServiceJni.testInstance = instance;
        }
      };
  private static ChromeUsbService.Natives testInstance;

  ChromeUsbServiceJni() {}

  @Override
  public void deviceAttached(
      long nativeUsbServiceAndroid, ChromeUsbService caller, UsbDevice device) {
    if (nativeUsbServiceAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_device_usb_ChromeUsbService_deviceAttached(
        nativeUsbServiceAndroid, caller, device);
  }

  @Override
  public void deviceDetached(long nativeUsbServiceAndroid, ChromeUsbService caller, int deviceId) {
    if (nativeUsbServiceAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_device_usb_ChromeUsbService_deviceDetached(
        nativeUsbServiceAndroid, caller, deviceId);
  }

  @Override
  public void devicePermissionRequestComplete(
      long nativeUsbServiceAndroid, ChromeUsbService caller, int deviceId, boolean granted) {
    if (nativeUsbServiceAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_device_usb_ChromeUsbService_devicePermissionRequestComplete(
        nativeUsbServiceAndroid, caller, deviceId, granted);
  }

  public static ChromeUsbService.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ChromeUsbService.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ChromeUsbService.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ChromeUsbServiceJni();
  }
}
