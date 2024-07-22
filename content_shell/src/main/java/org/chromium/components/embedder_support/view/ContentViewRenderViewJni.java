package org.chromium.components.embedder_support.view;

import android.view.Surface;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.WindowAndroid;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ContentViewRenderViewJni implements ContentViewRenderView.Natives {

  public static final JniStaticTestMocker<ContentViewRenderView.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ContentViewRenderView.Natives>() {
        @Override
        public void setInstanceForTesting(ContentViewRenderView.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ContentViewRenderViewJni.testInstance = instance;
        }
      };
  private static ContentViewRenderView.Natives testInstance;

  ContentViewRenderViewJni() {}

  @Override
  public void destroy(long nativeContentViewRenderView, ContentViewRenderView caller) {
    if (nativeContentViewRenderView == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_components_embedder_1support_view_ContentViewRenderView_destroy(
        nativeContentViewRenderView, caller);
  }

  @Override
  public long init(ContentViewRenderView caller, WindowAndroid rootWindow) {
    return GEN_JNI.org_chromium_components_embedder_1support_view_ContentViewRenderView_init(
        caller, rootWindow);
  }

  @Override
  public void onPhysicalBackingSizeChanged(
      long nativeContentViewRenderView,
      ContentViewRenderView caller,
      WebContents webContents,
      int width,
      int height) {
    if (nativeContentViewRenderView == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_components_embedder_1support_view_ContentViewRenderView_onPhysicalBackingSizeChanged(
            nativeContentViewRenderView, caller, webContents, width, height);
  }

  @Override
  public void setCurrentWebContents(
      long nativeContentViewRenderView, ContentViewRenderView caller, WebContents webContents) {
    if (nativeContentViewRenderView == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_components_embedder_1support_view_ContentViewRenderView_setCurrentWebContents(
            nativeContentViewRenderView, caller, webContents);
  }

  @Override
  public void setOverlayVideoMode(
      long nativeContentViewRenderView, ContentViewRenderView caller, boolean enabled) {
    if (nativeContentViewRenderView == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_components_embedder_1support_view_ContentViewRenderView_setOverlayVideoMode(
            nativeContentViewRenderView, caller, enabled);
  }

  @Override
  public void surfaceChanged(
      long nativeContentViewRenderView,
      ContentViewRenderView caller,
      int format,
      int width,
      int height,
      Surface surface) {
    if (nativeContentViewRenderView == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_components_embedder_1support_view_ContentViewRenderView_surfaceChanged(
        nativeContentViewRenderView, caller, format, width, height, surface);
  }

  @Override
  public void surfaceCreated(long nativeContentViewRenderView, ContentViewRenderView caller) {
    if (nativeContentViewRenderView == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_components_embedder_1support_view_ContentViewRenderView_surfaceCreated(
        nativeContentViewRenderView, caller);
  }

  @Override
  public void surfaceDestroyed(long nativeContentViewRenderView, ContentViewRenderView caller) {
    if (nativeContentViewRenderView == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_components_embedder_1support_view_ContentViewRenderView_surfaceDestroyed(
        nativeContentViewRenderView, caller);
  }

  public static ContentViewRenderView.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ContentViewRenderView.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ContentViewRenderView.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ContentViewRenderViewJni();
  }
}
