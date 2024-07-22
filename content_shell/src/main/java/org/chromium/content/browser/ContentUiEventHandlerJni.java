package org.chromium.content.browser;

import org.chromium.content_public.browser.WebContents;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ContentUiEventHandlerJni implements ContentUiEventHandler.Natives {

  public static final JniStaticTestMocker<ContentUiEventHandler.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ContentUiEventHandler.Natives>() {
        @Override
        public void setInstanceForTesting(ContentUiEventHandler.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ContentUiEventHandlerJni.testInstance = instance;
        }
      };
  private static ContentUiEventHandler.Natives testInstance;

  ContentUiEventHandlerJni() {}

  @Override
  public void cancelFling(
      long nativeContentUiEventHandler, ContentUiEventHandler caller, long timeMs) {
    if (nativeContentUiEventHandler == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_ContentUiEventHandler_cancelFling(
        nativeContentUiEventHandler, caller, timeMs);
  }

  @Override
  public long init(ContentUiEventHandler caller, WebContents webContents) {
    return GEN_JNI.org_chromium_content_browser_ContentUiEventHandler_init(caller, webContents);
  }

  @Override
  public void sendMouseEvent(
      long nativeContentUiEventHandler,
      ContentUiEventHandler caller,
      long timeNs,
      int action,
      float x,
      float y,
      int pointerId,
      float pressure,
      float orientation,
      float tilt,
      int changedButton,
      int buttonState,
      int metaState,
      int toolType) {
    if (nativeContentUiEventHandler == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_ContentUiEventHandler_sendMouseEvent(
        nativeContentUiEventHandler,
        caller,
        timeNs,
        action,
        x,
        y,
        pointerId,
        pressure,
        orientation,
        tilt,
        changedButton,
        buttonState,
        metaState,
        toolType);
  }

  @Override
  public void sendMouseWheelEvent(
      long nativeContentUiEventHandler,
      ContentUiEventHandler caller,
      long timeNs,
      float x,
      float y,
      float ticksX,
      float ticksY) {
    if (nativeContentUiEventHandler == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_ContentUiEventHandler_sendMouseWheelEvent(
        nativeContentUiEventHandler, caller, timeNs, x, y, ticksX, ticksY);
  }

  @Override
  public void sendScrollEvent(
      long nativeContentUiEventHandler,
      ContentUiEventHandler caller,
      long timeMs,
      float deltaX,
      float deltaY) {
    if (nativeContentUiEventHandler == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_ContentUiEventHandler_sendScrollEvent(
        nativeContentUiEventHandler, caller, timeMs, deltaX, deltaY);
  }

  public static ContentUiEventHandler.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ContentUiEventHandler.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ContentUiEventHandler.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ContentUiEventHandlerJni();
  }
}
