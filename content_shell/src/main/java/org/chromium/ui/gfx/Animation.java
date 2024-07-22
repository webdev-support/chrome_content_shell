package org.chromium.ui.gfx;

import android.provider.Settings;
import org.chromium.base.ContextUtils;
import org.jni_zero.JNINamespace;

@JNINamespace("gfx")
public class Animation {
  private static boolean prefersReducedMotion() {
    float durationScale =
        Settings.Global.getFloat(
            ContextUtils.getApplicationContext().getContentResolver(),
            "animator_duration_scale",
            1.0f);
    return ((double) durationScale) == 0.0d;
  }
}
