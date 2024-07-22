package org.chromium.device.gamepad;

import android.os.Build;
import android.os.CombinedVibration;
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.VibratorManager;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import org.chromium.net.NetError;

class GamepadDevice {

  static final int FF_STRONG_MAGNITUDE_CHANNEL_IDX = 0;
  static final int FF_WEAK_MAGNITUDE_CHANNEL_IDX = 1;
  static final int MAX_BTN_TRIGGER_HAPPY = 719;
  static final int MAX_BUTTON_INDEX = 17;
  static final int MAX_RAW_AXIS_VALUES = 256;
  static final int MAX_RAW_BUTTON_VALUES = 256;
  static final int MIN_BTN_TRIGGER_HAPPY = 704;
  static final int[] RELEVANT_KEYCODES = {
    19, 20, 21, 22, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 130
  };
  static final long VIBRATION_DEFAULT_DURATION_MILLIS = 5000;
  static final int VIBRATION_MAX_AMPLITUDE = 255;
  private int[] mAxes;
  private int mDeviceId;
  private int mDeviceIndex;
  private String mDeviceName;
  private int mDeviceProductId;
  private int mDeviceVendorId;
  private GamepadMappings mMappings;
  private boolean mSupportsDualRumble;
  private VibratorManager mVibratorManager;
  private final float[] mAxisValues = new float[4];
  private final float[] mButtonsValues = new float[19];
  private final float[] mRawButtons = new float[256];
  private final float[] mRawAxes = new float[256];
  private long mTimestamp = SystemClock.uptimeMillis();

  public GamepadDevice(int index, InputDevice inputDevice) {
    this.mDeviceIndex = index;
    this.mDeviceId = inputDevice.getId();
    this.mDeviceName = inputDevice.getName();
    this.mDeviceVendorId = inputDevice.getVendorId();
    this.mDeviceProductId = inputDevice.getProductId();
    List<InputDevice.MotionRange> ranges = inputDevice.getMotionRanges();
    this.mAxes = new int[ranges.size()];
    int i = 0;
    for (InputDevice.MotionRange range : ranges) {
      if ((range.getSource() & 16) != 0) {
        int axis = range.getAxis();
        if (axis >= 256) {
          throw new AssertionError();
        }
        this.mAxes[i] = axis;
        i++;
      }
    }
    int[] iArr = RELEVANT_KEYCODES;
    boolean z = true;
    int maxKeycode = iArr[iArr.length - 1];
    BitSet buttons = new BitSet(maxKeycode);
    boolean[] presentKeys = inputDevice.hasKeys(iArr);
    int j = 0;
    while (true) {
      int[] iArr2 = RELEVANT_KEYCODES;
      if (j >= iArr2.length) {
        break;
      }
      if (presentKeys[j]) {
        buttons.set(iArr2[j]);
      }
      j++;
    }
    this.mMappings = GamepadMappings.getMappings(inputDevice, this.mAxes, buttons);
    if (Build.VERSION.SDK_INT >= 31) {
      VibratorManager vibratorManager = inputDevice.getVibratorManager();
      int[] vibratorIds = vibratorManager.getVibratorIds();
      if (vibratorIds.length >= 2) {
        z =
            (vibratorManager.getVibrator(vibratorIds[0]).hasAmplitudeControl()
                    && vibratorManager.getVibrator(vibratorIds[1]).hasAmplitudeControl())
                ? z
                : false;
        this.mSupportsDualRumble = z;
        if (z) {
          this.mVibratorManager = vibratorManager;
        }
      }
    }
  }

  public void updateButtonsAndAxesMapping() {
    this.mMappings.mapToStandardGamepad(
        this.mAxisValues, this.mButtonsValues, this.mRawAxes, this.mRawButtons);
  }

  public int getId() {
    return this.mDeviceId;
  }

  public boolean isStandardGamepad() {
    return this.mMappings.isStandard();
  }

  public String getName() {
    return this.mDeviceName;
  }

  public int getVendorId() {
    return this.mDeviceVendorId;
  }

  public int getProductId() {
    return this.mDeviceProductId;
  }

  public int getIndex() {
    return this.mDeviceIndex;
  }

  public long getTimestamp() {
    return this.mTimestamp;
  }

  public float[] getAxes() {
    return this.mAxisValues;
  }

  public float[] getButtons() {
    return this.mButtonsValues;
  }

  public int getButtonsLength() {
    return this.mMappings.getButtonsLength();
  }

  public boolean supportsDualRumble() {
    return this.mSupportsDualRumble;
  }

  public void doVibration(double strongMagnitude, double weakMagnitude) {
    int strong = scaleMagnitude(strongMagnitude);
    int weak = scaleMagnitude(weakMagnitude);
    if (strong == 0 && weak == 0) {
      cancelVibration();
      return;
    }
    CombinedVibration.ParallelCombination effect = CombinedVibration.startParallel();
    if (strong > 0) {
      effect.addVibrator(
          0, VibrationEffect.createOneShot(VIBRATION_DEFAULT_DURATION_MILLIS, strong));
    }
    if (weak > 0) {
      effect.addVibrator(1, VibrationEffect.createOneShot(VIBRATION_DEFAULT_DURATION_MILLIS, weak));
    }
    this.mVibratorManager.vibrate(effect.combine());
  }

  private int scaleMagnitude(double magnitude) {
    return (int) Math.round(255.0d * Math.max(0.0d, Math.min(1.0d, magnitude)));
  }

  public void cancelVibration() {
    this.mVibratorManager.cancel();
  }

  public void clearData() {
    Arrays.fill(this.mAxisValues, 0.0f);
    Arrays.fill(this.mRawAxes, 0.0f);
    Arrays.fill(this.mButtonsValues, 0.0f);
    Arrays.fill(this.mRawButtons, 0.0f);
  }

  public boolean handleKeyEvent(KeyEvent event) {
    int keyCode = event.getKeyCode();
    int scanCode = event.getScanCode();
    if (keyCode == 0 && scanCode >= 704 && scanCode <= 719) {
      keyCode = scanCode + 188 + NetError.ERR_IMPORT_CERT_ALREADY_EXISTS;
    }
    if (GamepadList.isGamepadEvent(event)) {
      if (keyCode >= 256) {
        throw new AssertionError();
      }
      if (event.getAction() == 0) {
        this.mRawButtons[keyCode] = 1.0f;
      } else if (event.getAction() == 1) {
        this.mRawButtons[keyCode] = 0.0f;
      }
      this.mTimestamp = event.getEventTime();
      return true;
    }
    return false;
  }

  public boolean handleMotionEvent(MotionEvent event) {
    if (!GamepadList.isGamepadEvent(event)) {
      return false;
    }
    int i = 0;
    while (true) {
      int[] iArr = this.mAxes;
      if (i < iArr.length) {
        int axis = iArr[i];
        this.mRawAxes[axis] = event.getAxisValue(axis);
        i++;
      } else {
        this.mTimestamp = event.getEventTime();
        return true;
      }
    }
  }
}
