package org.chromium.content.browser.input;

import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import org.chromium.base.Log;
import org.chromium.content_public.browser.InputMethodManagerWrapper;

public class ThreadedInputConnectionFactory implements ChromiumBaseInputConnection.Factory {
  private static final int CHECK_REGISTER_RETRY = 1;
  private static final boolean DEBUG_LOGS = false;
  private static final String TAG = "Ime";
  private CheckInvalidator mCheckInvalidator;
  private final InputMethodManagerWrapper mInputMethodManagerWrapper;
  private ThreadedInputConnectionProxyView mProxyView;
  private boolean mReentrantTriggering;
  private ThreadedInputConnection mThreadedInputConnection;
  private int mFocusState = 0;
  private boolean mTriggerDelayedOnCreateInputConnection = true;

  @interface FocusState {
    public static final int NOT_APPLICABLE = 0;
    public static final int VIEW_FOCUSED_THEN_WINDOW_FOCUSED = 3;
    public static final int VIEW_FOCUSED_WITHOUT_WINDOW_FOCUS = 2;
    public static final int WINDOW_FOCUS_LOST = 1;
  }

  public static class LazyHandlerHolder {
    private static final Handler sHandler;

    private LazyHandlerHolder() {}

    static {
      HandlerThread handlerThread = new HandlerThread("InputConnectionHandlerThread", 5);
      handlerThread.start();
      sHandler = new Handler(handlerThread.getLooper());
    }
  }

  public static class CheckInvalidator {
    private boolean mInvalid;

    private CheckInvalidator() {}

    public void invalidate() {
      ImeUtils.checkOnUiThread();
      this.mInvalid = true;
    }

    public boolean isInvalid() {
      ImeUtils.checkOnUiThread();
      return this.mInvalid;
    }
  }

  public ThreadedInputConnectionFactory(InputMethodManagerWrapper inputMethodManagerWrapper) {
    this.mInputMethodManagerWrapper = inputMethodManagerWrapper;
  }

  @Override
  public Handler getHandler() {
    return LazyHandlerHolder.sHandler;
  }

  protected ThreadedInputConnectionProxyView createProxyView(Handler handler, View containerView) {
    return new ThreadedInputConnectionProxyView(
        containerView.getContext(), handler, containerView, this);
  }

  @Override
  public void setTriggerDelayedOnCreateInputConnection(boolean trigger) {
    this.mTriggerDelayedOnCreateInputConnection = trigger;
  }

  private boolean shouldTriggerDelayedOnCreateInputConnection() {
    return this.mTriggerDelayedOnCreateInputConnection;
  }

  @Override
  public ThreadedInputConnection initializeAndGet(
      View view,
      ImeAdapterImpl imeAdapter,
      int inputType,
      int inputFlags,
      int inputMode,
      int inputAction,
      int selectionStart,
      int selectionEnd,
      String lastText,
      EditorInfo outAttrs) {
    ImeUtils.checkOnUiThread();
    ImeUtils.computeEditorInfo(
        inputType,
        inputFlags,
        inputMode,
        inputAction,
        selectionStart,
        selectionEnd,
        lastText,
        outAttrs);
    if ("com.htc.android.mail".equals(view.getContext().getPackageName())) {
      CheckInvalidator checkInvalidator = this.mCheckInvalidator;
      if (checkInvalidator != null) {
        checkInvalidator.invalidate();
      }
      if (shouldTriggerDelayedOnCreateInputConnection()) {
        triggerDelayedOnCreateInputConnection(view);
        return null;
      }
    }
    ThreadedInputConnection threadedInputConnection = this.mThreadedInputConnection;
    if (threadedInputConnection == null) {
      this.mThreadedInputConnection = new ThreadedInputConnection(view, imeAdapter, getHandler());
    } else {
      threadedInputConnection.resetOnUiThread();
    }
    return this.mThreadedInputConnection;
  }

  private void triggerDelayedOnCreateInputConnection(final View view) {
    if (!this.mReentrantTriggering && view.hasFocus()) {
      this.mCheckInvalidator = new CheckInvalidator();
      if (!view.hasWindowFocus()) {
        this.mCheckInvalidator.invalidate();
      }
      ThreadedInputConnectionProxyView createProxyView = createProxyView(getHandler(), view);
      this.mProxyView = createProxyView;
      this.mReentrantTriggering = true;
      createProxyView.requestFocus();
      this.mReentrantTriggering = false;
      Runnable r =
          new Runnable() {
            @Override
            public void run() {
              ThreadedInputConnectionFactory.this.mProxyView.onWindowFocusChanged(true);
              ThreadedInputConnectionFactory.this.mInputMethodManagerWrapper.isActive(view);
              ThreadedInputConnectionFactory.this
                  .getHandler()
                  .post(
                      new Runnable() {
                        @Override
                        public void run() {
                          ThreadedInputConnectionFactory.this.postCheckRegisterResultOnUiThread(
                              view, ThreadedInputConnectionFactory.this.mCheckInvalidator, 1);
                        }
                      });
            }
          };
      if (this.mFocusState == 3) {
        postDelayed(view, r, 1000L);
        this.mFocusState = 0;
        return;
      }
      view.getHandler().post(r);
    }
  }

  protected void postDelayed(View view, Runnable r, long delayMs) {
    view.getHandler().postDelayed(r, delayMs);
  }

  public void postCheckRegisterResultOnUiThread(
      final View view, final CheckInvalidator checkInvalidator, final int retry) {
    Handler viewHandler = view.getHandler();
    if (viewHandler == null) {
      return;
    }
    viewHandler.post(
        new Runnable() {
          @Override
          public void run() {
            ThreadedInputConnectionFactory.this.checkRegisterResult(view, checkInvalidator, retry);
          }
        });
  }

  public void checkRegisterResult(View view, CheckInvalidator checkInvalidator, int retry) {
    if (this.mInputMethodManagerWrapper.isActive(this.mProxyView)) {
      onRegisterProxyViewSuccess();
    } else if (retry > 0) {
      postCheckRegisterResultOnUiThread(view, checkInvalidator, retry - 1);
    } else if (checkInvalidator.isInvalid()) {
    } else {
      onRegisterProxyViewFailure();
    }
  }

  protected void onRegisterProxyViewSuccess() {
    Log.d(TAG, "onRegisterProxyViewSuccess", new Object[0]);
  }

  protected void onRegisterProxyViewFailure() {
    Log.w(TAG, "onRegisterProxyViewFailure");
  }

  @Override
  public void onWindowFocusChanged(boolean gainFocus) {
    CheckInvalidator checkInvalidator;
    if (!gainFocus && (checkInvalidator = this.mCheckInvalidator) != null) {
      checkInvalidator.invalidate();
    }
    ThreadedInputConnectionProxyView threadedInputConnectionProxyView = this.mProxyView;
    if (threadedInputConnectionProxyView != null) {
      threadedInputConnectionProxyView.onOriginalViewWindowFocusChanged(gainFocus);
    }
    if (!gainFocus) {
      this.mFocusState = 1;
    } else if (gainFocus && this.mFocusState == 2) {
      this.mFocusState = 3;
    } else {
      this.mFocusState = 0;
    }
  }

  @Override
  public void onViewFocusChanged(boolean gainFocus) {
    CheckInvalidator checkInvalidator;
    if (!gainFocus && (checkInvalidator = this.mCheckInvalidator) != null) {
      checkInvalidator.invalidate();
    }
    ThreadedInputConnectionProxyView threadedInputConnectionProxyView = this.mProxyView;
    if (threadedInputConnectionProxyView != null) {
      threadedInputConnectionProxyView.onOriginalViewFocusChanged(gainFocus);
    }
    if (this.mFocusState == 1) {
      if (gainFocus) {
        this.mFocusState = 2;
        return;
      }
      return;
    }
    this.mFocusState = 0;
  }

  @Override
  public void onViewAttachedToWindow() {
    ThreadedInputConnectionProxyView threadedInputConnectionProxyView = this.mProxyView;
    if (threadedInputConnectionProxyView != null) {
      threadedInputConnectionProxyView.onOriginalViewAttachedToWindow();
    }
  }

  @Override
  public void onViewDetachedFromWindow() {
    CheckInvalidator checkInvalidator = this.mCheckInvalidator;
    if (checkInvalidator != null) {
      checkInvalidator.invalidate();
    }
    ThreadedInputConnectionProxyView threadedInputConnectionProxyView = this.mProxyView;
    if (threadedInputConnectionProxyView != null) {
      threadedInputConnectionProxyView.onOriginalViewDetachedFromWindow();
    }
    this.mThreadedInputConnection = null;
  }
}
