package org.chromium.device.gamepad;

import android.os.Build;
import android.view.InputDevice;
import java.util.BitSet;
import org.jni_zero.JNINamespace;

@JNINamespace("content")
abstract class GamepadMappings {
  static final String AMAZON_FIRE_DEVICE_NAME = "Amazon Fire Game Controller";
  static final int BROADCOM_VENDOR_ID = 2652;
  private static final float BUTTON_AXIS_DEADZONE = 0.01f;
  static final int GOOGLE_VENDOR_ID = 6353;
  static final int MICROSOFT_VENDOR_ID = 1118;
  static final String MICROSOFT_XBOX_PAD_DEVICE_NAME = "Microsoft X-Box 360 pad";
  static final String NVIDIA_SHIELD_DEVICE_NAME_PREFIX = "NVIDIA Corporation NVIDIA Controller";
  static final String PS_DUALSHOCK_3_SIXAXIS_DEVICE_NAME = "Sony PLAYSTATION(R)3 Controller";
  static final int PS_DUALSHOCK_4_PRODUCT_ID = 1476;
  static final int PS_DUALSHOCK_4_SLIM_PRODUCT_ID = 2508;
  static final int PS_DUALSHOCK_4_USB_RECEIVER_PRODUCT_ID = 2976;
  static final int PS_DUAL_SENSE_PRODUCT_ID = 3302;
  static final String SAMSUNG_EI_GP20_DEVICE_NAME = "Samsung Game Pad EI-GP20";
  static final int SNAKEBYTE_IDROIDCON_PRODUCT_ID = 34050;
  static final int SONY_VENDOR_ID = 1356;
  static final int STADIA_CONTROLLER_PRODUCT_ID = 37888;
  static final int XBOX_ONE_S_2016_FIRMWARE_PRODUCT_ID = 736;
  static final int XBOX_SERIES_X_BLUETOOTH_PRODUCT_ID = 2835;

  public abstract void mapToStandardGamepad(
      float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4);

  GamepadMappings() {}

  public static GamepadMappings getMappings(InputDevice device, int[] axes, BitSet buttons) {
    GamepadMappings mappings = getMappings(device.getVendorId(), device.getProductId(), axes);
    if (mappings == null) {
      mappings = getMappings(device.getName());
    }
    if (mappings == null) {
      return new UnknownGamepadMappings(axes, buttons);
    }
    return mappings;
  }

  static GamepadMappings getMappings(int vendorId, int productId, int[] axes) {
    if (vendorId == 1356) {
      if (productId == 1476 || productId == 2508 || productId == 2976) {
        if (Build.VERSION.SDK_INT >= 28) {
          return new XboxCompatibleGamepadMappings();
        }
        return new Ps4Ps5GamepadMappings();
      } else if (productId == 3302 && Build.VERSION.SDK_INT <= 30) {
        return new Ps4Ps5GamepadMappings();
      }
    }
    if (vendorId == 1118) {
      if (productId == 736) {
        return new XboxOneS2016FirmwareMappings();
      }
      if (productId == 2835) {
        return new XboxSeriesXBluetoothMappings();
      }
    }
    if (vendorId == BROADCOM_VENDOR_ID && productId == SNAKEBYTE_IDROIDCON_PRODUCT_ID) {
      return new SnakebyteIDroidConMappings(axes);
    }
    if (vendorId == GOOGLE_VENDOR_ID && productId == STADIA_CONTROLLER_PRODUCT_ID) {
      return new StadiaControllerMappings();
    }
    return null;
  }

  static GamepadMappings getMappings(String deviceName) {
    if (deviceName.startsWith(NVIDIA_SHIELD_DEVICE_NAME_PREFIX)
        || deviceName.equals(MICROSOFT_XBOX_PAD_DEVICE_NAME)) {
      return new XboxCompatibleGamepadMappings();
    }
    if (deviceName.equals(PS_DUALSHOCK_3_SIXAXIS_DEVICE_NAME)) {
      if (Build.VERSION.SDK_INT >= 28) {
        return new Dualshock3SixAxisGamepadMappings();
      }
      return new Dualshock3SixAxisGamepadMappingsPreP();
    } else if (deviceName.equals(SAMSUNG_EI_GP20_DEVICE_NAME)) {
      return new SamsungEIGP20GamepadMappings();
    } else {
      if (deviceName.equals(AMAZON_FIRE_DEVICE_NAME)) {
        return new AmazonFireGamepadMappings();
      }
      return null;
    }
  }

  static GamepadMappings getUnknownGamepadMappings(int[] axes, BitSet buttons) {
    return new UnknownGamepadMappings(axes, buttons);
  }

  public boolean isStandard() {
    return true;
  }

  public int getButtonsLength() {
    return 17;
  }

  public static void mapCommonXYABButtons(float[] mappedButtons, float[] rawButtons) {
    float a = rawButtons[96];
    float b = rawButtons[97];
    float x = rawButtons[99];
    float y = rawButtons[100];
    mappedButtons[0] = a;
    mappedButtons[1] = b;
    mappedButtons[2] = x;
    mappedButtons[3] = y;
  }

  public static void mapCommonStartSelectMetaButtons(float[] mappedButtons, float[] rawButtons) {
    float start = rawButtons[108];
    float select = rawButtons[109];
    float mode = rawButtons[110];
    mappedButtons[9] = start;
    mappedButtons[8] = select;
    mappedButtons[16] = mode;
  }

  public static void mapCommonThumbstickButtons(float[] mappedButtons, float[] rawButtons) {
    float thumbL = rawButtons[106];
    float thumbR = rawButtons[107];
    mappedButtons[10] = thumbL;
    mappedButtons[11] = thumbR;
  }

  public static void mapUpperTriggerButtonsToBottomShoulder(
      float[] mappedButtons, float[] rawButtons) {
    float l1 = rawButtons[102];
    float r1 = rawButtons[103];
    mappedButtons[6] = l1;
    mappedButtons[7] = r1;
  }

  public static void mapTriggerButtonsToTopShoulder(float[] mappedButtons, float[] rawButtons) {
    float l1 = rawButtons[102];
    float r1 = rawButtons[103];
    mappedButtons[4] = l1;
    mappedButtons[5] = r1;
  }

  public static void mapCommonDpadButtons(float[] mappedButtons, float[] rawButtons) {
    float dpadDown = rawButtons[20];
    float dpadUp = rawButtons[19];
    float dpadLeft = rawButtons[21];
    float dpadRight = rawButtons[22];
    mappedButtons[13] = dpadDown;
    mappedButtons[12] = dpadUp;
    mappedButtons[14] = dpadLeft;
    mappedButtons[15] = dpadRight;
  }

  public static void mapXYAxes(float[] mappedAxes, float[] rawAxes) {
    mappedAxes[0] = rawAxes[0];
    mappedAxes[1] = rawAxes[1];
  }

  public static void mapRXAndRYAxesToRightStick(float[] mappedAxes, float[] rawAxes) {
    mappedAxes[2] = rawAxes[12];
    mappedAxes[3] = rawAxes[13];
  }

  public static void mapZAndRZAxesToRightStick(float[] mappedAxes, float[] rawAxes) {
    mappedAxes[2] = rawAxes[11];
    mappedAxes[3] = rawAxes[14];
  }

  public static void mapPedalAxesToBottomShoulder(float[] mappedButtons, float[] rawAxes) {
    float lTrigger = rawAxes[23];
    float rTrigger = rawAxes[22];
    mappedButtons[6] = lTrigger;
    mappedButtons[7] = rTrigger;
  }

  public static void mapTriggerAxesToBottomShoulder(float[] mappedButtons, float[] rawAxes) {
    float lTrigger = rawAxes[17];
    float rTrigger = rawAxes[18];
    mappedButtons[6] = lTrigger;
    mappedButtons[7] = rTrigger;
  }

  public static void mapZAxisToBottomShoulder(float[] mappedButtons, float[] rawAxes) {
    float z = rawAxes[11];
    mappedButtons[6] = z > BUTTON_AXIS_DEADZONE ? z : 0.0f;
    mappedButtons[7] = (-z) > BUTTON_AXIS_DEADZONE ? -z : 0.0f;
  }

  public static void mapLowerTriggerButtonsToBottomShoulder(
      float[] mappedButtons, float[] rawButtons) {
    float l2 = rawButtons[104];
    float r2 = rawButtons[105];
    mappedButtons[6] = l2;
    mappedButtons[7] = r2;
  }

  static float negativeAxisValueAsButton(float input) {
    return input < -0.5f ? 1.0f : 0.0f;
  }

  static float positiveAxisValueAsButton(float input) {
    return input > 0.5f ? 1.0f : 0.0f;
  }

  public static void mapHatAxisToDpadButtons(float[] mappedButtons, float[] rawAxes) {
    float hatX = rawAxes[15];
    float hatY = rawAxes[16];
    mappedButtons[14] = negativeAxisValueAsButton(hatX);
    mappedButtons[15] = positiveAxisValueAsButton(hatX);
    mappedButtons[12] = negativeAxisValueAsButton(hatY);
    mappedButtons[13] = positiveAxisValueAsButton(hatY);
  }

  public static class AmazonFireGamepadMappings extends GamepadMappings {
    private AmazonFireGamepadMappings() {}

    @Override
    public void mapToStandardGamepad(
        float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
      GamepadMappings.mapCommonXYABButtons(mappedButtons, rawButtons);
      GamepadMappings.mapTriggerButtonsToTopShoulder(mappedButtons, rawButtons);
      GamepadMappings.mapCommonThumbstickButtons(mappedButtons, rawButtons);
      GamepadMappings.mapCommonStartSelectMetaButtons(mappedButtons, rawButtons);
      GamepadMappings.mapPedalAxesToBottomShoulder(mappedButtons, rawAxes);
      GamepadMappings.mapHatAxisToDpadButtons(mappedButtons, rawAxes);
      GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
      GamepadMappings.mapZAndRZAxesToRightStick(mappedAxes, rawAxes);
    }
  }

  public static class XboxCompatibleGamepadMappings extends GamepadMappings {
    private XboxCompatibleGamepadMappings() {}

    @Override
    public void mapToStandardGamepad(
        float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
      GamepadMappings.mapCommonXYABButtons(mappedButtons, rawButtons);
      GamepadMappings.mapTriggerButtonsToTopShoulder(mappedButtons, rawButtons);
      GamepadMappings.mapCommonThumbstickButtons(mappedButtons, rawButtons);
      GamepadMappings.mapCommonStartSelectMetaButtons(mappedButtons, rawButtons);
      GamepadMappings.mapTriggerAxesToBottomShoulder(mappedButtons, rawAxes);
      GamepadMappings.mapHatAxisToDpadButtons(mappedButtons, rawAxes);
      GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
      GamepadMappings.mapZAndRZAxesToRightStick(mappedAxes, rawAxes);
    }
  }

  public static class SnakebyteIDroidConMappings extends GamepadMappings {
    private final boolean mAnalogMode;

    public SnakebyteIDroidConMappings(int[] axes) {
      this.mAnalogMode = arrayContains(axes, 12);
    }

    private static boolean arrayContains(int[] array, int element) {
      for (int e : array) {
        if (e == element) {
          return true;
        }
      }
      return false;
    }

    @Override
    public int getButtonsLength() {
      return 16;
    }

    @Override
    public void mapToStandardGamepad(
        float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
      GamepadMappings.mapCommonXYABButtons(mappedButtons, rawButtons);
      GamepadMappings.mapTriggerButtonsToTopShoulder(mappedButtons, rawButtons);
      GamepadMappings.mapCommonStartSelectMetaButtons(mappedButtons, rawButtons);
      GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
      GamepadMappings.mapHatAxisToDpadButtons(mappedButtons, rawAxes);
      float thumbL = rawButtons[106];
      float thumbR = rawButtons[107];
      float c = rawButtons[98];
      float z = rawButtons[101];
      mappedButtons[10] = Math.max(thumbL, c);
      mappedButtons[11] = Math.max(thumbR, z);
      if (this.mAnalogMode) {
        GamepadMappings.mapZAxisToBottomShoulder(mappedButtons, rawAxes);
        GamepadMappings.mapRXAndRYAxesToRightStick(mappedAxes, rawAxes);
        return;
      }
      GamepadMappings.mapLowerTriggerButtonsToBottomShoulder(mappedButtons, rawButtons);
      GamepadMappings.mapZAndRZAxesToRightStick(mappedAxes, rawAxes);
    }
  }

  public static class XboxOneS2016FirmwareMappings extends GamepadMappings {
    private boolean mLeftTriggerActivated;
    private boolean mRightTriggerActivated;

    private XboxOneS2016FirmwareMappings() {}

    @Override
    public void mapToStandardGamepad(
        float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
      mappedButtons[0] = rawButtons[96];
      mappedButtons[1] = rawButtons[97];
      mappedButtons[2] = rawButtons[98];
      mappedButtons[3] = rawButtons[99];
      mappedButtons[4] = rawButtons[100];
      mappedButtons[5] = rawButtons[101];
      mappedButtons[8] = rawButtons[102];
      mappedButtons[9] = rawButtons[103];
      mappedButtons[10] = rawButtons[104];
      mappedButtons[11] = rawButtons[105];
      if (rawAxes[11] != 0.0f) {
        this.mLeftTriggerActivated = true;
      }
      if (rawAxes[14] != 0.0f) {
        this.mRightTriggerActivated = true;
      }
      if (this.mLeftTriggerActivated) {
        mappedButtons[6] = (rawAxes[11] + 1.0f) / 2.0f;
      } else {
        mappedButtons[6] = 0.0f;
      }
      if (this.mRightTriggerActivated) {
        mappedButtons[7] = (rawAxes[14] + 1.0f) / 2.0f;
      } else {
        mappedButtons[7] = 0.0f;
      }
      GamepadMappings.mapHatAxisToDpadButtons(mappedButtons, rawAxes);
      GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
      GamepadMappings.mapRXAndRYAxesToRightStick(mappedAxes, rawAxes);
    }

    @Override
    public int getButtonsLength() {
      return 16;
    }
  }

  public static class XboxSeriesXBluetoothMappings extends GamepadMappings {
    private static final int BUTTON_INDEX_SHARE = 17;

    private XboxSeriesXBluetoothMappings() {}

    @Override
    public void mapToStandardGamepad(
        float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
      GamepadMappings.mapCommonXYABButtons(mappedButtons, rawButtons);
      GamepadMappings.mapTriggerButtonsToTopShoulder(mappedButtons, rawButtons);
      GamepadMappings.mapCommonThumbstickButtons(mappedButtons, rawButtons);
      GamepadMappings.mapCommonStartSelectMetaButtons(mappedButtons, rawButtons);
      GamepadMappings.mapHatAxisToDpadButtons(mappedButtons, rawAxes);
      GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
      GamepadMappings.mapZAndRZAxesToRightStick(mappedAxes, rawAxes);
      GamepadMappings.mapPedalAxesToBottomShoulder(mappedButtons, rawAxes);
      mappedButtons[17] = rawButtons[130];
    }

    @Override
    public int getButtonsLength() {
      return 18;
    }
  }

  public static class Dualshock3SixAxisGamepadMappingsPreP extends GamepadMappings {
    private Dualshock3SixAxisGamepadMappingsPreP() {}

    @Override
    public void mapToStandardGamepad(
        float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
      float a = rawButtons[96];
      float b = rawButtons[97];
      float x = rawButtons[99];
      float y = rawButtons[100];
      mappedButtons[0] = x;
      mappedButtons[1] = y;
      mappedButtons[2] = a;
      mappedButtons[3] = b;
      GamepadMappings.mapTriggerButtonsToTopShoulder(mappedButtons, rawButtons);
      GamepadMappings.mapCommonThumbstickButtons(mappedButtons, rawButtons);
      GamepadMappings.mapCommonDpadButtons(mappedButtons, rawButtons);
      GamepadMappings.mapCommonStartSelectMetaButtons(mappedButtons, rawButtons);
      GamepadMappings.mapTriggerAxesToBottomShoulder(mappedButtons, rawAxes);
      GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
      GamepadMappings.mapZAndRZAxesToRightStick(mappedAxes, rawAxes);
    }
  }

  public static class Dualshock3SixAxisGamepadMappings extends GamepadMappings {
    private Dualshock3SixAxisGamepadMappings() {}

    @Override
    public void mapToStandardGamepad(
        float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
      GamepadMappings.mapCommonXYABButtons(mappedButtons, rawButtons);
      GamepadMappings.mapTriggerButtonsToTopShoulder(mappedButtons, rawButtons);
      GamepadMappings.mapCommonThumbstickButtons(mappedButtons, rawButtons);
      GamepadMappings.mapCommonStartSelectMetaButtons(mappedButtons, rawButtons);
      GamepadMappings.mapCommonDpadButtons(mappedButtons, rawButtons);
      GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
      GamepadMappings.mapZAndRZAxesToRightStick(mappedAxes, rawAxes);
      GamepadMappings.mapTriggerAxesToBottomShoulder(mappedButtons, rawAxes);
    }
  }

  public static class Ps4Ps5GamepadMappings extends GamepadMappings {
    Ps4Ps5GamepadMappings() {}

    private static float scaleRxRy(float input) {
      return 1.0f - ((1.0f - input) / 2.0f);
    }

    @Override
    public void mapToStandardGamepad(
        float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
      float a = rawButtons[96];
      float b = rawButtons[97];
      float c = rawButtons[98];
      float x = rawButtons[99];
      mappedButtons[0] = b;
      mappedButtons[1] = c;
      mappedButtons[2] = a;
      mappedButtons[3] = x;
      float y = rawButtons[100];
      float z = rawButtons[101];
      mappedButtons[4] = y;
      mappedButtons[5] = z;
      float rx = rawAxes[12];
      float ry = rawAxes[13];
      mappedButtons[6] = scaleRxRy(rx);
      mappedButtons[7] = scaleRxRy(ry);
      float share = rawButtons[104];
      float options = rawButtons[105];
      mappedButtons[8] = share;
      mappedButtons[9] = options;
      float thumbL = rawButtons[109];
      float thumbR = rawButtons[108];
      mappedButtons[10] = thumbL;
      mappedButtons[11] = thumbR;
      float mode = rawButtons[110];
      mappedButtons[16] = mode;
      GamepadMappings.mapHatAxisToDpadButtons(mappedButtons, rawAxes);
      GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
      GamepadMappings.mapZAndRZAxesToRightStick(mappedAxes, rawAxes);
    }
  }

  public static class SamsungEIGP20GamepadMappings extends GamepadMappings {
    private SamsungEIGP20GamepadMappings() {}

    @Override
    public void mapToStandardGamepad(
        float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
      GamepadMappings.mapCommonXYABButtons(mappedButtons, rawButtons);
      GamepadMappings.mapUpperTriggerButtonsToBottomShoulder(mappedButtons, rawButtons);
      GamepadMappings.mapCommonThumbstickButtons(mappedButtons, rawButtons);
      GamepadMappings.mapCommonStartSelectMetaButtons(mappedButtons, rawButtons);
      GamepadMappings.mapHatAxisToDpadButtons(mappedButtons, rawAxes);
      GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
      GamepadMappings.mapRXAndRYAxesToRightStick(mappedAxes, rawAxes);
    }
  }

  public static class StadiaControllerMappings extends GamepadMappings {
    private static final int BUTTON_INDEX_ASSISTANT = 17;
    private static final int BUTTON_INDEX_CAPTURE = 18;

    private StadiaControllerMappings() {}

    @Override
    public void mapToStandardGamepad(
        float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
      GamepadMappings.mapCommonXYABButtons(mappedButtons, rawButtons);
      GamepadMappings.mapTriggerButtonsToTopShoulder(mappedButtons, rawButtons);
      GamepadMappings.mapPedalAxesToBottomShoulder(mappedButtons, rawAxes);
      GamepadMappings.mapCommonThumbstickButtons(mappedButtons, rawButtons);
      GamepadMappings.mapCommonStartSelectMetaButtons(mappedButtons, rawButtons);
      GamepadMappings.mapHatAxisToDpadButtons(mappedButtons, rawAxes);
      mappedButtons[17] = rawButtons[188];
      mappedButtons[18] = rawButtons[189];
      GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
      GamepadMappings.mapZAndRZAxesToRightStick(mappedAxes, rawAxes);
    }

    @Override
    public int getButtonsLength() {
      return 19;
    }
  }

  private static class UnknownGamepadMappings extends GamepadMappings {
    private final boolean mHasMetaButton;
    private int mLeftTriggerAxis;
    private int mRightStickXAxis;
    private int mRightStickYAxis;
    private int mRightTriggerAxis;
    private boolean mUseHatAxes;

    UnknownGamepadMappings(int[] axes, BitSet buttons) {
      this.mLeftTriggerAxis = -1;
      this.mRightTriggerAxis = -1;
      this.mRightStickXAxis = -1;
      this.mRightStickYAxis = -1;
      this.mHasMetaButton = buttons.get(110);
      int hatAxesFound = 0;
      for (int axis : axes) {
        switch (axis) {
          case 11:
          case 12:
            this.mRightStickXAxis = axis;
            break;
          case 13:
          case 14:
            this.mRightStickYAxis = axis;
            break;
          case 15:
            hatAxesFound++;
            break;
          case 16:
            hatAxesFound++;
            break;
          case 17:
          case 23:
            this.mLeftTriggerAxis = axis;
            break;
          case 18:
          case 19:
          case 22:
            this.mRightTriggerAxis = axis;
            break;
        }
      }
      if (hatAxesFound == 2) {
        this.mUseHatAxes = true;
      }
    }

    @Override
    public boolean isStandard() {
      return false;
    }

    @Override
    public int getButtonsLength() {
      return this.mHasMetaButton ? 17 : 16;
    }

    @Override
    public void mapToStandardGamepad(
        float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
      int i;
      int i2;
      GamepadMappings.mapCommonXYABButtons(mappedButtons, rawButtons);
      GamepadMappings.mapTriggerButtonsToTopShoulder(mappedButtons, rawButtons);
      GamepadMappings.mapCommonThumbstickButtons(mappedButtons, rawButtons);
      GamepadMappings.mapCommonStartSelectMetaButtons(mappedButtons, rawButtons);
      GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
      int i3 = this.mLeftTriggerAxis;
      if (i3 != -1 && (i2 = this.mRightTriggerAxis) != -1) {
        float lTrigger = rawAxes[i3];
        float rTrigger = rawAxes[i2];
        mappedButtons[6] = lTrigger;
        mappedButtons[7] = rTrigger;
      } else {
        GamepadMappings.mapLowerTriggerButtonsToBottomShoulder(mappedButtons, rawButtons);
      }
      int i4 = this.mRightStickXAxis;
      if (i4 != -1 && (i = this.mRightStickYAxis) != -1) {
        float rX = rawAxes[i4];
        float rY = rawAxes[i];
        mappedAxes[2] = rX;
        mappedAxes[3] = rY;
      }
      if (this.mUseHatAxes) {
        GamepadMappings.mapHatAxisToDpadButtons(mappedButtons, rawAxes);
      } else {
        GamepadMappings.mapCommonDpadButtons(mappedButtons, rawButtons);
      }
    }
  }
}
