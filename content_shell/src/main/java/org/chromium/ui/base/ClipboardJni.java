package org.chromium.ui.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ClipboardJni implements Clipboard.Natives {

  public static final JniStaticTestMocker<Clipboard.Natives> TEST_HOOKS =
      new JniStaticTestMocker<Clipboard.Natives>() {
        @Override
        public void setInstanceForTesting(Clipboard.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ClipboardJni.testInstance = instance;
        }
      };
  private static Clipboard.Natives testInstance;

  ClipboardJni() {}

  @Override
  public void cleanupForTesting() {
    GEN_JNI.org_chromium_ui_base_Clipboard_cleanupForTesting();
  }

  @Override
  public long getLastModifiedTimeToJavaTime(long nativeClipboardAndroid) {
    if (nativeClipboardAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_ui_base_Clipboard_getLastModifiedTimeToJavaTime(
        nativeClipboardAndroid);
  }

  @Override
  public void onPrimaryClipChanged(long nativeClipboardAndroid, Clipboard caller) {
    if (nativeClipboardAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_Clipboard_onPrimaryClipChanged(nativeClipboardAndroid, caller);
  }

  @Override
  public void onPrimaryClipTimestampInvalidated(
      long nativeClipboardAndroid, Clipboard caller, long timestamp) {
    if (nativeClipboardAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_Clipboard_onPrimaryClipTimestampInvalidated(
        nativeClipboardAndroid, caller, timestamp);
  }

  public static Clipboard.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      Clipboard.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of Clipboard.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ClipboardJni();
  }
}
