package org.chromium.ui.events.devices;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class InputDeviceObserverJni implements InputDeviceObserver.Natives {
  public static final JniStaticTestMocker<InputDeviceObserver.Natives> TEST_HOOKS =
      new JniStaticTestMocker<InputDeviceObserver.Natives>() {
        @Override
        public void setInstanceForTesting(InputDeviceObserver.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          InputDeviceObserverJni.testInstance = instance;
        }
      };
  private static InputDeviceObserver.Natives testInstance;

  InputDeviceObserverJni() {}

  @Override
  public void inputConfigurationChanged(InputDeviceObserver caller) {
    GEN_JNI.org_chromium_ui_events_devices_InputDeviceObserver_inputConfigurationChanged(caller);
  }

  public static InputDeviceObserver.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      InputDeviceObserver.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of InputDeviceObserver.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new InputDeviceObserverJni();
  }
}
