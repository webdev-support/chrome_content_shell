package org.chromium.content.browser.androidoverlay;

import android.view.Surface;
import org.chromium.gfx.mojom.Rect;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class DialogOverlayImplJni implements DialogOverlayImpl.Natives {

  public static final JniStaticTestMocker<DialogOverlayImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<DialogOverlayImpl.Natives>() {
        @Override
        public void setInstanceForTesting(DialogOverlayImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          DialogOverlayImplJni.testInstance = instance;
        }
      };
  private static DialogOverlayImpl.Natives testInstance;

  DialogOverlayImplJni() {}

  @Override
  public void completeInit(long nativeDialogOverlayImpl, DialogOverlayImpl caller) {
    if (nativeDialogOverlayImpl == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_androidoverlay_DialogOverlayImpl_completeInit(
        nativeDialogOverlayImpl, caller);
  }

  @Override
  public void destroy(long nativeDialogOverlayImpl, DialogOverlayImpl caller) {
    if (nativeDialogOverlayImpl == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_androidoverlay_DialogOverlayImpl_destroy(
        nativeDialogOverlayImpl, caller);
  }

  @Override
  public void getCompositorOffset(
      long nativeDialogOverlayImpl, DialogOverlayImpl caller, Rect rect) {
    if (nativeDialogOverlayImpl == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_androidoverlay_DialogOverlayImpl_getCompositorOffset(
        nativeDialogOverlayImpl, caller, rect);
  }

  @Override
  public long init(DialogOverlayImpl caller, long high, long low, boolean isPowerEfficient) {
    return GEN_JNI.org_chromium_content_browser_androidoverlay_DialogOverlayImpl_init(
        caller, high, low, isPowerEfficient);
  }

  @Override
  public Surface lookupSurfaceForTesting(int surfaceId) {
    return (Surface)
        GEN_JNI
            .org_chromium_content_browser_androidoverlay_DialogOverlayImpl_lookupSurfaceForTesting(
                surfaceId);
  }

  @Override
  public void notifyDestroyedSynchronously(long messagePipeHandle) {
    GEN_JNI
        .org_chromium_content_browser_androidoverlay_DialogOverlayImpl_notifyDestroyedSynchronously(
            messagePipeHandle);
  }

  @Override
  public int registerSurface(Surface surface) {
    return GEN_JNI.org_chromium_content_browser_androidoverlay_DialogOverlayImpl_registerSurface(
        surface);
  }

  @Override
  public void unregisterSurface(int surfaceId) {
    GEN_JNI.org_chromium_content_browser_androidoverlay_DialogOverlayImpl_unregisterSurface(
        surfaceId);
  }

  public static DialogOverlayImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      DialogOverlayImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of DialogOverlayImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new DialogOverlayImplJni();
  }
}
