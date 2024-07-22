package org.chromium.ui.gfx;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ViewConfigurationHelperJni implements ViewConfigurationHelper.Natives {
  public static final JniStaticTestMocker<ViewConfigurationHelper.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ViewConfigurationHelper.Natives>() {

        @Override
        public void setInstanceForTesting(ViewConfigurationHelper.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ViewConfigurationHelperJni.testInstance = instance;
        }
      };
  private static ViewConfigurationHelper.Natives testInstance;

  ViewConfigurationHelperJni() {}

  @Override
  public void updateSharedViewConfiguration(
      ViewConfigurationHelper caller,
      float maximumFlingVelocity,
      float minimumFlingVelocity,
      float touchSlop,
      float doubleTapSlop,
      float minScalingSpan) {
    GEN_JNI.org_chromium_ui_gfx_ViewConfigurationHelper_updateSharedViewConfiguration(
        caller,
        maximumFlingVelocity,
        minimumFlingVelocity,
        touchSlop,
        doubleTapSlop,
        minScalingSpan);
  }

  public static ViewConfigurationHelper.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ViewConfigurationHelper.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ViewConfigurationHelper.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ViewConfigurationHelperJni();
  }
}
