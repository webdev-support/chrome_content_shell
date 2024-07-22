package org.chromium.ui.base;

// import org.jni_zero.GEN_JNI;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class WindowAndroidJni implements WindowAndroid.Natives {

  public static final JniStaticTestMocker<WindowAndroid.Natives> TEST_HOOKS =
      new JniStaticTestMocker<WindowAndroid.Natives>() {
        @Override
        public void setInstanceForTesting(WindowAndroid.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          WindowAndroidJni.testInstance = instance;
        }
      };
  private static WindowAndroid.Natives testInstance;

  WindowAndroidJni() {}

  @Override
  public void destroy(long nativeWindowAndroid, WindowAndroid caller) {
    if (nativeWindowAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_WindowAndroid_destroy(nativeWindowAndroid, caller);
  }

  @Override
  public long init(
      WindowAndroid caller, int displayId, float scrollFactor, boolean windowIsWideColorGamut) {
    return GEN_JNI.org_chromium_ui_base_WindowAndroid_init(
        caller, displayId, scrollFactor, windowIsWideColorGamut);
  }

  @Override
  public void onActivityStarted(long nativeWindowAndroid, WindowAndroid caller) {
    if (nativeWindowAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_WindowAndroid_onActivityStarted(nativeWindowAndroid, caller);
  }

  @Override
  public void onActivityStopped(long nativeWindowAndroid, WindowAndroid caller) {
    if (nativeWindowAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_WindowAndroid_onActivityStopped(nativeWindowAndroid, caller);
  }

  @Override
  public void onOverlayTransformUpdated(long nativeWindowAndroid, WindowAndroid caller) {
    if (nativeWindowAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_WindowAndroid_onOverlayTransformUpdated(
        nativeWindowAndroid, caller);
  }

  @Override
  public void onSupportedRefreshRatesUpdated(
      long nativeWindowAndroid, WindowAndroid caller, float[] supportedRefreshRates) {
    if (nativeWindowAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_WindowAndroid_onSupportedRefreshRatesUpdated(
        nativeWindowAndroid, caller, supportedRefreshRates);
  }

  @Override
  public void onUpdateRefreshRate(
      long nativeWindowAndroid, WindowAndroid caller, float refreshRate) {
    if (nativeWindowAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_WindowAndroid_onUpdateRefreshRate(
        nativeWindowAndroid, caller, refreshRate);
  }

  @Override
  public void onVisibilityChanged(long nativeWindowAndroid, WindowAndroid caller, boolean visible) {
    if (nativeWindowAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_WindowAndroid_onVisibilityChanged(
        nativeWindowAndroid, caller, visible);
  }

  @Override
  public void sendUnfoldLatencyBeginTimestamp(long nativeWindowAndroid, long beginTimestampMs) {
    if (nativeWindowAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_WindowAndroid_sendUnfoldLatencyBeginTimestamp(
        nativeWindowAndroid, beginTimestampMs);
  }

  @Override
  public void setVSyncPaused(long nativeWindowAndroid, WindowAndroid caller, boolean paused) {
    if (nativeWindowAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_WindowAndroid_setVSyncPaused(nativeWindowAndroid, caller, paused);
  }

  public static WindowAndroid.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      WindowAndroid.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of WindowAndroid.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new WindowAndroidJni();
  }
}
