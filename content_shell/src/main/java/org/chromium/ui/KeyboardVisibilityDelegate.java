package org.chromium.ui;

import android.content.Context;
import android.os.Handler;
import android.os.StrictMode;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.WindowInsetsCompat;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.base.Log;
import org.chromium.base.ObserverList;
import org.chromium.base.TraceEvent;

public class KeyboardVisibilityDelegate {
  private static final int KEYBOARD_RETRY_ATTEMPTS = 10;
  private static final long KEYBOARD_RETRY_DELAY_MS = 100;
  private static final String TAG = "KeyboardVisibility";
  private static KeyboardVisibilityDelegate sInstance = new KeyboardVisibilityDelegate();
  private final ObserverList<KeyboardVisibilityListener> mKeyboardVisibilityListeners =
      new ObserverList<>();

  public interface KeyboardVisibilityListener {
    void keyboardVisibilityChanged(boolean z);
  }

  protected void registerKeyboardVisibilityCallbacks() {}

  protected void unregisterKeyboardVisibilityCallbacks() {}

  public static void setInstance(KeyboardVisibilityDelegate delegate) {
    sInstance = delegate;
  }

  public static KeyboardVisibilityDelegate getInstance() {
    return sInstance;
  }

  public void showKeyboard(final View view) {
    final Handler handler = new Handler();
    final AtomicInteger attempt = new AtomicInteger();
    Runnable openRunnable =
        new Runnable() {
          @Override
          public void run() {
            InputMethodManager imm =
                (InputMethodManager) view.getContext().getSystemService("input_method");
            StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskWrites();
            try {
              try {
                imm.showSoftInput(view, 0);
              } catch (IllegalArgumentException e) {
                if (attempt.incrementAndGet() <= 10) {
                  handler.postDelayed(this, KeyboardVisibilityDelegate.KEYBOARD_RETRY_DELAY_MS);
                } else {
                  Log.e(
                      KeyboardVisibilityDelegate.TAG,
                      "Unable to open keyboard.  Giving up.",
                      (Throwable) e);
                }
              }
            } finally {
              StrictMode.setThreadPolicy(oldPolicy);
            }
          }
        };
    openRunnable.run();
  }

  public boolean hideKeyboard(View view) {
    return hideAndroidSoftKeyboard(view);
  }

  protected boolean hideAndroidSoftKeyboard(View view) {
    if (view.isAttachedToWindow()) {
      InputMethodManager imm =
          (InputMethodManager) view.getContext().getSystemService("input_method");
      return imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    return false;
  }

  public int calculateKeyboardHeight(View rootView) {
    TraceEvent te = TraceEvent.scoped("KeyboardVisibilityDelegate.calculateKeyboardHeight");
    if (rootView != null) {
      try {
        if (rootView.getRootWindowInsets() != null) {
          WindowInsetsCompat windowInsetsCompat =
              WindowInsetsCompat.toWindowInsetsCompat(rootView.getRootWindowInsets(), rootView);
          int imeHeightIncludingNavigationBar =
              windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime()).bottom;
          if (imeHeightIncludingNavigationBar != 0) {
            int navigationBarHeight =
                windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
            int i = imeHeightIncludingNavigationBar - navigationBarHeight;
            if (te != null) {
              te.close();
            }
            return i;
          }
          if (te != null) {
            te.close();
          }
          return 0;
        }
      } catch (Throwable th) {
        if (te != null) {
          try {
            te.close();
          } catch (Throwable th2) {
            th.addSuppressed(th2);
          }
        }
        throw th;
      }
    }
    if (te != null) {
      te.close();
    }
    return 0;
  }

  public int calculateTotalKeyboardHeight(View rootView) {
    return calculateKeyboardHeight(rootView);
  }

  public boolean isKeyboardShowing(Context context, View view) {
    return isAndroidSoftKeyboardShowing(context, view);
  }

  protected boolean isAndroidSoftKeyboardShowing(Context context, View view) {
    View rootView = view.getRootView();
    return rootView != null && calculateKeyboardHeight(rootView) > 0;
  }

  public void notifyListeners(boolean isShowing) {
    Iterator<KeyboardVisibilityListener> it = this.mKeyboardVisibilityListeners.iterator();
    while (it.hasNext()) {
      KeyboardVisibilityListener listener = it.next();
      listener.keyboardVisibilityChanged(isShowing);
    }
  }

  public void addKeyboardVisibilityListener(KeyboardVisibilityListener listener) {
    if (this.mKeyboardVisibilityListeners.isEmpty()) {
      registerKeyboardVisibilityCallbacks();
    }
    this.mKeyboardVisibilityListeners.addObserver(listener);
  }

  public void removeKeyboardVisibilityListener(KeyboardVisibilityListener listener) {
    this.mKeyboardVisibilityListeners.removeObserver(listener);
    if (this.mKeyboardVisibilityListeners.isEmpty()) {
      unregisterKeyboardVisibilityCallbacks();
    }
  }
}
