package org.chromium.device.gamepad;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class GamepadListJni implements GamepadList.Natives {
  public static final JniStaticTestMocker<GamepadList.Natives> TEST_HOOKS =
      new JniStaticTestMocker<GamepadList.Natives>() {
        @Override
        public void setInstanceForTesting(GamepadList.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          GamepadListJni.testInstance = instance;
        }
      };
  private static GamepadList.Natives testInstance;

  GamepadListJni() {}

  @Override
  public void setGamepadData(
      GamepadList caller,
      long webGamepadsPtr,
      int index,
      boolean mapping,
      boolean connected,
      String devicename,
      int vendorId,
      int productId,
      long timestamp,
      float[] axes,
      float[] buttons,
      int buttonsLength,
      boolean supportsDualRumble) {
    GEN_JNI.org_chromium_device_gamepad_GamepadList_setGamepadData(
        caller,
        webGamepadsPtr,
        index,
        mapping,
        connected,
        devicename,
        vendorId,
        productId,
        timestamp,
        axes,
        buttons,
        buttonsLength,
        supportsDualRumble);
  }

  public static GamepadList.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      GamepadList.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of GamepadList.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new GamepadListJni();
  }
}
