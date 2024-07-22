package org.chromium.device.power_save_blocker;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
class PowerSaveBlocker {

  private static final WeakHashMap<View, Integer> sBlockViewCounter = new WeakHashMap<>();
  private WeakReference<View> mKeepScreenOnView;

  private static PowerSaveBlocker create() {
    return new PowerSaveBlocker();
  }

  private PowerSaveBlocker() {}

  private void applyBlock(View view) {
    if (this.mKeepScreenOnView != null) {
      throw new AssertionError();
    }
    this.mKeepScreenOnView = new WeakReference<>(view);
    WeakHashMap<View, Integer> weakHashMap = sBlockViewCounter;
    Integer prev_counter = weakHashMap.get(view);
    if (prev_counter == null) {
      weakHashMap.put(view, 1);
    } else if (prev_counter.intValue() >= 0) {
      weakHashMap.put(view, Integer.valueOf(prev_counter.intValue() + 1));
    } else {
      throw new AssertionError();
    }
    if (prev_counter == null || prev_counter.intValue() == 0) {
      view.setKeepScreenOn(true);
    }
  }

  private void removeBlock() {
    WeakReference<View> weakReference = this.mKeepScreenOnView;
    if (weakReference == null) {
      return;
    }
    View view = weakReference.get();
    this.mKeepScreenOnView = null;
    if (view == null) {
      return;
    }
    WeakHashMap<View, Integer> weakHashMap = sBlockViewCounter;
    Integer prev_counter = weakHashMap.get(view);
    if (prev_counter == null) {
      throw new AssertionError();
    }
    if (prev_counter.intValue() <= 0) {
      throw new AssertionError();
    }
    weakHashMap.put(view, Integer.valueOf(prev_counter.intValue() - 1));
    if (prev_counter.intValue() == 1) {
      view.setKeepScreenOn(false);
    }
  }
}
