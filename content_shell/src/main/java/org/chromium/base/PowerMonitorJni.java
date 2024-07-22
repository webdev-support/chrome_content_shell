package org.chromium.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class PowerMonitorJni implements PowerMonitor.Natives {
  public static final JniStaticTestMocker<PowerMonitor.Natives> TEST_HOOKS =
      new JniStaticTestMocker<PowerMonitor.Natives>() {
        @Override
        public void setInstanceForTesting(PowerMonitor.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          PowerMonitorJni.testInstance = instance;
        }
      };
  private static PowerMonitor.Natives testInstance;

  PowerMonitorJni() {}

  @Override
  public void onBatteryChargingChanged() {
    GEN_JNI.org_chromium_base_PowerMonitor_onBatteryChargingChanged();
  }

  @Override
  public void onThermalStatusChanged(int thermalStatus) {
    GEN_JNI.org_chromium_base_PowerMonitor_onThermalStatusChanged(thermalStatus);
  }

  public static PowerMonitor.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      PowerMonitor.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of PowerMonitor.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new PowerMonitorJni();
  }
}
