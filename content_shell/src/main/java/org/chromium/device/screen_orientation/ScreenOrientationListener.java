package org.chromium.device.screen_orientation;

import android.provider.Settings;
import org.chromium.base.ContextUtils;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
class ScreenOrientationListener {
  ScreenOrientationListener() {}

  static boolean isAutoRotateEnabledByUser() {
    return Settings.System.getInt(
            ContextUtils.getApplicationContext().getContentResolver(), "accelerometer_rotation", 0)
        == 1;
  }
}
