package org.chromium.ui.accessibility;

import android.os.Build;
import org.jni_zero.JNINamespace;

@JNINamespace("ui")
public class AccessibilityAutofillHelper {
  public static boolean shouldRespectDisplayedPasswordText() {
    return isAutofillOnlyPossibleAccessibilityConsumer();
  }

  public static boolean shouldExposePasswordText() {
    if (Build.VERSION.SDK_INT >= 28 && isAutofillOnlyPossibleAccessibilityConsumer()) {
      return true;
    }
    return AccessibilityState.isTextShowPasswordEnabled();
  }

  public static boolean isAutofillOnlyPossibleAccessibilityConsumer() {
    return !AccessibilityState.isAnyAccessibilityServiceEnabled();
  }
}
