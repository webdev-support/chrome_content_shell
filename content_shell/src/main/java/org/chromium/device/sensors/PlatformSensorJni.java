package org.chromium.device.sensors;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class PlatformSensorJni implements PlatformSensor.Natives {

  public static final JniStaticTestMocker<PlatformSensor.Natives> TEST_HOOKS =
      new JniStaticTestMocker<PlatformSensor.Natives>() {
        @Override
        public void setInstanceForTesting(PlatformSensor.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          PlatformSensorJni.testInstance = instance;
        }
      };
  private static PlatformSensor.Natives testInstance;

  PlatformSensorJni() {}

  @Override
  public void notifyPlatformSensorError(long nativePlatformSensorAndroid, PlatformSensor caller) {
    if (nativePlatformSensorAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_device_sensors_PlatformSensor_notifyPlatformSensorError(
        nativePlatformSensorAndroid, caller);
  }

  @Override
  public void updatePlatformSensorReading(
      long nativePlatformSensorAndroid,
      PlatformSensor caller,
      double timestamp,
      double value1,
      double value2,
      double value3,
      double value4) {
    if (nativePlatformSensorAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_device_sensors_PlatformSensor_updatePlatformSensorReading(
        nativePlatformSensorAndroid, caller, timestamp, value1, value2, value3, value4);
  }

  public static PlatformSensor.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      PlatformSensor.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of PlatformSensor.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new PlatformSensorJni();
  }
}
