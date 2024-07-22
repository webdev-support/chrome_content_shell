package org.chromium.ui.base;

import android.view.InputDevice;
import org.chromium.base.ContextUtils;
import org.jni_zero.JNINamespace;

@JNINamespace("ui")
public class TouchDevice {
  private TouchDevice() {}

  private static int maxTouchPoints() {
    if (ContextUtils.getApplicationContext()
        .getPackageManager()
        .hasSystemFeature("android.hardware.touchscreen.multitouch.jazzhand")) {
      return 5;
    }
    if (ContextUtils.getApplicationContext()
            .getPackageManager()
            .hasSystemFeature("android.hardware.touchscreen.multitouch.distinct")
        || ContextUtils.getApplicationContext()
            .getPackageManager()
            .hasSystemFeature("android.hardware.touchscreen.multitouch")) {
      return 2;
    }
    if (ContextUtils.getApplicationContext()
        .getPackageManager()
        .hasSystemFeature("android.hardware.touchscreen")) {
      return 1;
    }
    return 0;
  }

  private static int[] availablePointerAndHoverTypes() {
    int[] deviceIds;
    int pointerTypes = 0;
    int hoverTypes = 0;
    for (int deviceId : InputDevice.getDeviceIds()) {
      InputDevice inputDevice = null;
      try {
        inputDevice = InputDevice.getDevice(deviceId);
      } catch (RuntimeException e) {
      }
      if (inputDevice != null) {
        int sources = inputDevice.getSources();
        boolean isFinePointer =
            hasSource(sources, 8194)
                || hasSource(sources, 16386)
                || hasSource(sources, 1048584)
                || hasSource(sources, 65540);
        if (isFinePointer) {
          pointerTypes |= 4;
        }
        if (hasSource(sources, 4098)
            && (UiAndroidFeatureMap.isEnabled(UiAndroidFeatures.REPORT_ALL_AVAILABLE_POINTER_TYPES)
                || !isFinePointer)) {
          pointerTypes |= 2;
        }
        if (hasSource(sources, 8194) || hasSource(sources, 1048584) || hasSource(sources, 65540)) {
          hoverTypes |= 2;
        }
      }
    }
    if (pointerTypes == 0) {
      pointerTypes = 1;
    }
    if (hoverTypes == 0) {
      hoverTypes = 1;
    }
    return new int[] {pointerTypes, hoverTypes};
  }

  private static boolean hasSource(int sources, int inputDeviceSource) {
    return (sources & inputDeviceSource) == inputDeviceSource;
  }
}
