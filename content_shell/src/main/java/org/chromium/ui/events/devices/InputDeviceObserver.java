package org.chromium.ui.events.devices;

import android.content.Context;
import android.hardware.input.InputManager;
import android.util.ArrayMap;
import android.view.InputDevice;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.metrics.RecordHistogram;
import org.jni_zero.JNINamespace;

@JNINamespace("ui")
public class InputDeviceObserver implements InputManager.InputDeviceListener {

  private static final InputDeviceObserver INSTANCE = new InputDeviceObserver();
  private static final String KEYBOARD_CONNECTION_HISTOGRAM_NAME =
      "Android.InputDevice.Keyboard.Active";
  private static final String MOUSE_CONNECTION_HISTOGRAM_NAME = "Android.InputDevice.Mouse.Active";
  private final ArrayMap<Integer, Integer> mActiveDeviceMap = new ArrayMap<>();
  private InputManager mInputManager;
  private int mObserversCounter;

  public interface Natives {
    void inputConfigurationChanged(InputDeviceObserver inputDeviceObserver);
  }

  public static void addObserver() {
    if (!ThreadUtils.runningOnUiThread()) {
      throw new AssertionError();
    }
    INSTANCE.attachObserver();
  }

  public static void removeObserver() {
    if (!ThreadUtils.runningOnUiThread()) {
      throw new AssertionError();
    }
    INSTANCE.detachObserver();
  }

  @Override
  public void onInputDeviceChanged(int deviceId) {
    InputDeviceObserverJni.get().inputConfigurationChanged(this);
  }

  @Override
  public void onInputDeviceRemoved(int deviceId) {
    InputDeviceObserverJni.get().inputConfigurationChanged(this);
    if (this.mActiveDeviceMap.containsKey(Integer.valueOf(deviceId))) {
      if (this.mActiveDeviceMap.get(Integer.valueOf(deviceId)).intValue() == 257) {
        RecordHistogram.recordBooleanHistogram(KEYBOARD_CONNECTION_HISTOGRAM_NAME, false);
      } else if (this.mActiveDeviceMap.get(Integer.valueOf(deviceId)).intValue() == 8194) {
        RecordHistogram.recordBooleanHistogram(MOUSE_CONNECTION_HISTOGRAM_NAME, false);
      }
      this.mActiveDeviceMap.remove(Integer.valueOf(deviceId));
    }
  }

  @Override
  public void onInputDeviceAdded(int deviceId) {
    InputDeviceObserverJni.get().inputConfigurationChanged(this);
    InputDevice device = InputDevice.getDevice(deviceId);
    if (device == null) {
      return;
    }
    if ((device.getSources() & 257) == 257) {
      this.mActiveDeviceMap.put(Integer.valueOf(deviceId), 257);
      RecordHistogram.recordBooleanHistogram(KEYBOARD_CONNECTION_HISTOGRAM_NAME, true);
    } else if ((device.getSources() & 8194) == 8194) {
      this.mActiveDeviceMap.put(Integer.valueOf(deviceId), 8194);
      RecordHistogram.recordBooleanHistogram(MOUSE_CONNECTION_HISTOGRAM_NAME, true);
    }
  }

  private void attachObserver() {
    int i = this.mObserversCounter;
    this.mObserversCounter = i + 1;
    if (i == 0) {
      Context context = ContextUtils.getApplicationContext();
      InputManager inputManager = (InputManager) context.getSystemService("input");
      this.mInputManager = inputManager;
      inputManager.registerInputDeviceListener(this, null);
    }
  }

  private void detachObserver() {
    int i = this.mObserversCounter;
    if (i <= 0) {
      throw new AssertionError();
    }
    int i2 = i - 1;
    this.mObserversCounter = i2;
    if (i2 == 0) {
      this.mInputManager.unregisterInputDeviceListener(this);
      this.mInputManager = null;
    }
  }
}
