package org.chromium.ui.base;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.ContextUtils;
import org.chromium.ui.permissions.ActivityAndroidPermissionDelegate;

public class ActivityWindowAndroid extends WindowAndroid
    implements ApplicationStatus.ActivityStateListener,
        ApplicationStatus.WindowFocusChangedListener {
  private ImmutableWeakReference<Activity> mActivityWeakRefHolder;
  private final boolean mListenToActivityState;

  public ActivityWindowAndroid(
      Context context, boolean listenToActivityState, IntentRequestTracker intentRequestTracker) {
    this(
        context,
        listenToActivityState,
        new ActivityAndroidPermissionDelegate(
            new WeakReference(ContextUtils.activityFromContext(context))),
        new ActivityKeyboardVisibilityDelegate(
            new WeakReference(ContextUtils.activityFromContext(context))),
        intentRequestTracker);
  }

  public ActivityWindowAndroid(
      Context context,
      boolean listenToActivityState,
      ActivityKeyboardVisibilityDelegate keyboardVisibilityDelegate,
      IntentRequestTracker intentRequestTracker) {
    this(
        context,
        listenToActivityState,
        new ActivityAndroidPermissionDelegate(
            new WeakReference(ContextUtils.activityFromContext(context))),
        keyboardVisibilityDelegate,
        intentRequestTracker);
  }

  private ActivityWindowAndroid(
      Context context,
      boolean listenToActivityState,
      ActivityAndroidPermissionDelegate activityAndroidPermissionDelegate,
      ActivityKeyboardVisibilityDelegate activityKeyboardVisibilityDelegate,
      IntentRequestTracker intentRequestTracker) {
    super(context, intentRequestTracker);
    Activity activity = ContextUtils.activityFromContext(context);
    if (activity == null) {
      throw new IllegalArgumentException("Context is not and does not wrap an Activity");
    }
    this.mListenToActivityState = listenToActivityState;
    if (listenToActivityState) {
      ApplicationStatus.registerStateListenerForActivity(this, activity);
      ApplicationStatus.registerWindowFocusChangedListener(this);
    }
    setKeyboardDelegate(activityKeyboardVisibilityDelegate);
    setAndroidPermissionDelegate(activityAndroidPermissionDelegate);
  }

  @Override
  public ActivityKeyboardVisibilityDelegate getKeyboardDelegate() {
    return (ActivityKeyboardVisibilityDelegate) super.getKeyboardDelegate();
  }

  @Override
  public WeakReference<Activity> getActivity() {
    if (this.mActivityWeakRefHolder == null) {
      this.mActivityWeakRefHolder =
          new ImmutableWeakReference<>(ContextUtils.activityFromContext(getContext().get()));
    }
    return this.mActivityWeakRefHolder;
  }

  @Override
  public void onActivityStateChange(Activity activity, int newState) {
    if (newState == 5) {
      onActivityStopped();
    } else if (newState == 2) {
      onActivityStarted();
    } else if (newState == 4) {
      onActivityPaused();
    } else if (newState == 3) {
      onActivityResumed();
    } else if (newState == 6) {
      onActivityDestroyed();
      ApplicationStatus.unregisterWindowFocusChangedListener(this);
    }
  }

  @Override
  public int getActivityState() {
    if (this.mListenToActivityState) {
      return ApplicationStatus.getStateForActivity(getActivity().get());
    }
    return super.getActivityState();
  }

  @Override
  public void onWindowFocusChanged(Activity activity, boolean hasFocus) {
    if (getActivity().get() == activity) {
      onWindowFocusChanged(hasFocus);
    }
  }
}
