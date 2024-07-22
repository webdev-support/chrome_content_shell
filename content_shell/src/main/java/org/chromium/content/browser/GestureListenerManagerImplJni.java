//
// This file was generated by third_party/jni_zero/jni_generator.py
//
package org.chromium.content.browser;

import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.jni_zero.CheckDiscard;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

@CheckDiscard("crbug.com/993421")
class GestureListenerManagerImplJni implements GestureListenerManagerImpl.Natives {
  private static GestureListenerManagerImpl.Natives testInstance;

  public static final JniStaticTestMocker<GestureListenerManagerImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<GestureListenerManagerImpl.Natives>() {
        @Override
        public void setInstanceForTesting(GestureListenerManagerImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          testInstance = instance;
        }
      };

  @Override
  public long init(GestureListenerManagerImpl caller, WebContentsImpl webContents) {
    return (long)
        GEN_JNI.org_chromium_content_browser_GestureListenerManagerImpl_init(caller, webContents);
  }

  @Override
  public void resetGestureDetection(
      long nativeGestureListenerManager, GestureListenerManagerImpl caller) {
    assert nativeGestureListenerManager != 0;
    GEN_JNI.org_chromium_content_browser_GestureListenerManagerImpl_resetGestureDetection(
        nativeGestureListenerManager, caller);
  }

  @Override
  public void setDoubleTapSupportEnabled(
      long nativeGestureListenerManager, GestureListenerManagerImpl caller, boolean enabled) {
    assert nativeGestureListenerManager != 0;
    GEN_JNI.org_chromium_content_browser_GestureListenerManagerImpl_setDoubleTapSupportEnabled(
        nativeGestureListenerManager, caller, enabled);
  }

  @Override
  public void setMultiTouchZoomSupportEnabled(
      long nativeGestureListenerManager, GestureListenerManagerImpl caller, boolean enabled) {
    assert nativeGestureListenerManager != 0;
    GEN_JNI.org_chromium_content_browser_GestureListenerManagerImpl_setMultiTouchZoomSupportEnabled(
        nativeGestureListenerManager, caller, enabled);
  }

  @Override
  public void setRootScrollOffsetUpdateFrequency(long nativeGestureListenerManager, int frequency) {
    assert nativeGestureListenerManager != 0;
    GEN_JNI
        .org_chromium_content_browser_GestureListenerManagerImpl_setRootScrollOffsetUpdateFrequency(
            nativeGestureListenerManager, frequency);
  }

  public static GestureListenerManagerImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of GestureListenerManagerImpl.Natives. "
                + "The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new GestureListenerManagerImplJni();
  }
}