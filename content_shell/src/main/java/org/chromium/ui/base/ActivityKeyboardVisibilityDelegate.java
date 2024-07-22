package org.chromium.ui.base;

import android.app.Activity;
import android.view.View;
import java.lang.ref.WeakReference;
import org.chromium.ui.KeyboardVisibilityDelegate;

public class ActivityKeyboardVisibilityDelegate extends KeyboardVisibilityDelegate
    implements View.OnLayoutChangeListener {
  private WeakReference<Activity> mActivity;
  private boolean mIsKeyboardShowing;

  public ActivityKeyboardVisibilityDelegate(WeakReference<Activity> activity) {
    this.mActivity = activity;
  }

  public Activity getActivity() {
    return this.mActivity.get();
  }

  @Override
  public void registerKeyboardVisibilityCallbacks() {
    Activity activity = getActivity();
    if (activity == null) {
      return;
    }
    View content = activity.findViewById(16908290);
    this.mIsKeyboardShowing = isKeyboardShowing(activity, content);
    content.addOnLayoutChangeListener(this);
  }

  @Override
  public void unregisterKeyboardVisibilityCallbacks() {
    Activity activity = getActivity();
    if (activity == null) {
      return;
    }
    activity.findViewById(16908290).removeOnLayoutChangeListener(this);
  }

  @Override
  public void onLayoutChange(
      View v,
      int left,
      int top,
      int right,
      int bottom,
      int oldLeft,
      int oldTop,
      int oldRight,
      int oldBottom) {
    boolean isShowing;
    Activity activity = getActivity();
    if (activity == null
        || this.mIsKeyboardShowing == (isShowing = isKeyboardShowing(activity, v))) {
      return;
    }
    this.mIsKeyboardShowing = isShowing;
    notifyListeners(isShowing);
  }
}
