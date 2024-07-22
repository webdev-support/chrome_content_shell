package org.chromium.content_public.browser;

import android.util.ArraySet;
import android.view.InputDevice;
import org.chromium.content.browser.DeviceUtilsImpl;

public final class DeviceUtils {
  private DeviceUtils() {}

  public static void addDeviceSpecificUserAgentSwitch() {
    DeviceUtilsImpl.addDeviceSpecificUserAgentSwitch();
  }

  public static void updateDeviceSpecificUserAgentSwitch(boolean isTablet) {
    DeviceUtilsImpl.updateDeviceSpecificUserAgentSwitch(isTablet);
  }

  public static ArraySet<Integer> getConnectedDevices() {
    int[] deviceIds = InputDevice.getDeviceIds();
    ArraySet<Integer> deviceSources = new ArraySet<>();
    for (int deviceId : deviceIds) {
      if (isDeviceOfSourceType(deviceId, 257)) {
        deviceSources.add(257);
      } else if (isDeviceOfSourceType(deviceId, 8194)) {
        deviceSources.add(8194);
      } else if (isDeviceOfSourceType(deviceId, 1048584)) {
        deviceSources.add(1048584);
      } else if (isDeviceOfSourceType(deviceId, 65540)) {
        deviceSources.add(65540);
      } else if (isDeviceOfSourceType(deviceId, 16386) || isDeviceOfSourceType(deviceId, 49154)) {
        deviceSources.add(16386);
      }
    }
    return deviceSources;
  }

  private static boolean isDeviceOfSourceType(int deviceId, int sourceType) {
    InputDevice device = InputDevice.getDevice(deviceId);
    return device != null && (device.getSources() & sourceType) == sourceType;
  }
}
