package org.chromium.content.browser;

import org.chromium.base.Callback;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class RenderWidgetHostViewImplJni implements RenderWidgetHostViewImpl.Natives {

  public static final JniStaticTestMocker<RenderWidgetHostViewImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<RenderWidgetHostViewImpl.Natives>() {
        @Override
        public void setInstanceForTesting(RenderWidgetHostViewImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          RenderWidgetHostViewImplJni.testInstance = instance;
        }
      };
  private static RenderWidgetHostViewImpl.Natives testInstance;

  RenderWidgetHostViewImplJni() {}

  @Override
  public void dismissTextHandles(
      long nativeRenderWidgetHostViewAndroid, RenderWidgetHostViewImpl caller) {
    if (nativeRenderWidgetHostViewAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_RenderWidgetHostViewImpl_dismissTextHandles(
        nativeRenderWidgetHostViewAndroid, caller);
  }

  @Override
  public int getBackgroundColor(
      long nativeRenderWidgetHostViewAndroid, RenderWidgetHostViewImpl caller) {
    if (nativeRenderWidgetHostViewAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_content_browser_RenderWidgetHostViewImpl_getBackgroundColor(
        nativeRenderWidgetHostViewAndroid, caller);
  }

  @Override
  public boolean isReady(long nativeRenderWidgetHostViewAndroid, RenderWidgetHostViewImpl caller) {
    if (nativeRenderWidgetHostViewAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_content_browser_RenderWidgetHostViewImpl_isReady(
        nativeRenderWidgetHostViewAndroid, caller);
  }

  @Override
  public void onViewportInsetBottomChanged(
      long nativeRenderWidgetHostViewAndroid, RenderWidgetHostViewImpl caller) {
    if (nativeRenderWidgetHostViewAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_RenderWidgetHostViewImpl_onViewportInsetBottomChanged(
        nativeRenderWidgetHostViewAndroid, caller);
  }

  @Override
  public void showContextMenuAtTouchHandle(
      long nativeRenderWidgetHostViewAndroid, RenderWidgetHostViewImpl caller, int x, int y) {
    if (nativeRenderWidgetHostViewAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_RenderWidgetHostViewImpl_showContextMenuAtTouchHandle(
        nativeRenderWidgetHostViewAndroid, caller, x, y);
  }

  @Override
  public void writeContentBitmapToDiskAsync(
      long nativeRenderWidgetHostViewAndroid,
      RenderWidgetHostViewImpl caller,
      int width,
      int height,
      String path,
      Callback callback) {
    if (nativeRenderWidgetHostViewAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_RenderWidgetHostViewImpl_writeContentBitmapToDiskAsync(
        nativeRenderWidgetHostViewAndroid, caller, width, height, path, callback);
  }

  public static RenderWidgetHostViewImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      RenderWidgetHostViewImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of RenderWidgetHostViewImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new RenderWidgetHostViewImplJni();
  }
}
