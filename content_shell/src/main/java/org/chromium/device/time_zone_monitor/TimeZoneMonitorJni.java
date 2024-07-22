package org.chromium.device.time_zone_monitor;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class TimeZoneMonitorJni implements TimeZoneMonitor.Natives {

  public static final JniStaticTestMocker<TimeZoneMonitor.Natives> TEST_HOOKS =
      new JniStaticTestMocker<TimeZoneMonitor.Natives>() {
        @Override
        public void setInstanceForTesting(TimeZoneMonitor.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          TimeZoneMonitorJni.testInstance = instance;
        }
      };
  private static TimeZoneMonitor.Natives testInstance;

  TimeZoneMonitorJni() {}

  @Override
  public void timeZoneChangedFromJava(long nativeTimeZoneMonitorAndroid, TimeZoneMonitor caller) {
    if (nativeTimeZoneMonitorAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_device_time_1zone_1monitor_TimeZoneMonitor_timeZoneChangedFromJava(
        nativeTimeZoneMonitorAndroid, caller);
  }

  public static TimeZoneMonitor.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      TimeZoneMonitor.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of TimeZoneMonitor.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new TimeZoneMonitorJni();
  }
}
