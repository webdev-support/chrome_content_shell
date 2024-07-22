package org.chromium.ui.base;

import android.view.KeyEvent;
import android.view.MotionEvent;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class EventForwarderJni implements EventForwarder.Natives {

  public static final JniStaticTestMocker<EventForwarder.Natives> TEST_HOOKS =
      new JniStaticTestMocker<EventForwarder.Natives>() {
        @Override
        public void setInstanceForTesting(EventForwarder.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          EventForwarderJni.testInstance = instance;
        }
      };
  private static EventForwarder.Natives testInstance;

  EventForwarderJni() {}

  @Override
  public void cancelFling(
      long nativeEventForwarder, EventForwarder caller, long timeMs, boolean preventBoosting) {
    if (nativeEventForwarder == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_EventForwarder_cancelFling(
        nativeEventForwarder, caller, timeMs, preventBoosting);
  }

  @Override
  public boolean dispatchKeyEvent(
      long nativeEventForwarder, EventForwarder caller, KeyEvent event) {
    if (nativeEventForwarder == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_ui_base_EventForwarder_dispatchKeyEvent(
        nativeEventForwarder, caller, event);
  }

  @Override
  public void doubleTap(
      long nativeEventForwarder, EventForwarder caller, long timeMs, int x, int y) {
    if (nativeEventForwarder == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_EventForwarder_doubleTap(
        nativeEventForwarder, caller, timeMs, x, y);
  }

  @Override
  public WindowAndroid getJavaWindowAndroid(long nativeEventForwarder, EventForwarder caller) {
    if (nativeEventForwarder == 0) {
      throw new AssertionError();
    }
    return (WindowAndroid)
        GEN_JNI.org_chromium_ui_base_EventForwarder_getJavaWindowAndroid(
            nativeEventForwarder, caller);
  }

  @Override
  public void onDragEvent(
      long nativeEventForwarder,
      EventForwarder caller,
      int action,
      float x,
      float y,
      float screenX,
      float screenY,
      String[] mimeTypes,
      String content) {
    if (nativeEventForwarder == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_EventForwarder_onDragEvent(
        nativeEventForwarder, caller, action, x, y, screenX, screenY, mimeTypes, content);
  }

  @Override
  public boolean onGenericMotionEvent(
      long nativeEventForwarder, EventForwarder caller, MotionEvent event, long timeNs) {
    if (nativeEventForwarder == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_ui_base_EventForwarder_onGenericMotionEvent(
        nativeEventForwarder, caller, event, timeNs);
  }

  @Override
  public boolean onGestureEvent(
      long nativeEventForwarder, EventForwarder caller, int type, long timeMs, float delta) {
    if (nativeEventForwarder == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_ui_base_EventForwarder_onGestureEvent(
        nativeEventForwarder, caller, type, timeMs, delta);
  }

  @Override
  public boolean onKeyUp(
      long nativeEventForwarder, EventForwarder caller, KeyEvent event, int keyCode) {
    if (nativeEventForwarder == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_ui_base_EventForwarder_onKeyUp(
        nativeEventForwarder, caller, event, keyCode);
  }

  @Override
  public void onMouseEvent(
      long nativeEventForwarder,
      EventForwarder caller,
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
    if (nativeEventForwarder == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_EventForwarder_onMouseEvent(
        nativeEventForwarder,
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
  public boolean onTouchEvent(
      long nativeEventForwarder,
      EventForwarder caller,
      MotionEvent event,
      long oldestEventTimeNs,
      long latestEventTimeNs,
      int action,
      int pointerCount,
      int historySize,
      int actionIndex,
      float x0,
      float y0,
      float x1,
      float y1,
      int pointerId0,
      int pointerId1,
      float touchMajor0,
      float touchMajor1,
      float touchMinor0,
      float touchMinor1,
      float orientation0,
      float orientation1,
      float tilt0,
      float tilt1,
      float rawX,
      float rawY,
      int androidToolType0,
      int androidToolType1,
      int gestureClassification,
      int androidButtonState,
      int androidMetaState,
      boolean isTouchHandleEvent) {
    if (nativeEventForwarder == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_ui_base_EventForwarder_onTouchEvent(
        nativeEventForwarder,
        caller,
        event,
        oldestEventTimeNs,
        latestEventTimeNs,
        action,
        pointerCount,
        historySize,
        actionIndex,
        x0,
        y0,
        x1,
        y1,
        pointerId0,
        pointerId1,
        touchMajor0,
        touchMajor1,
        touchMinor0,
        touchMinor1,
        orientation0,
        orientation1,
        tilt0,
        tilt1,
        rawX,
        rawY,
        androidToolType0,
        androidToolType1,
        gestureClassification,
        androidButtonState,
        androidMetaState,
        isTouchHandleEvent);
  }

  @Override
  public void scrollBy(
      long nativeEventForwarder, EventForwarder caller, float deltaX, float deltaY) {
    if (nativeEventForwarder == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_EventForwarder_scrollBy(
        nativeEventForwarder, caller, deltaX, deltaY);
  }

  @Override
  public void scrollTo(long nativeEventForwarder, EventForwarder caller, float x, float y) {
    if (nativeEventForwarder == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_EventForwarder_scrollTo(nativeEventForwarder, caller, x, y);
  }

  @Override
  public void startFling(
      long nativeEventForwarder,
      EventForwarder caller,
      long timeMs,
      float velocityX,
      float velocityY,
      boolean syntheticScroll,
      boolean preventBoosting) {
    if (nativeEventForwarder == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_EventForwarder_startFling(
        nativeEventForwarder,
        caller,
        timeMs,
        velocityX,
        velocityY,
        syntheticScroll,
        preventBoosting);
  }

  public static EventForwarder.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      EventForwarder.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of EventForwarder.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new EventForwarderJni();
  }
}
