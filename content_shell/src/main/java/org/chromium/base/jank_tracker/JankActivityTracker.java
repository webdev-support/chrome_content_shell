package org.chromium.base.jank_tracker;

import android.app.Activity;
import java.lang.ref.WeakReference;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.ThreadUtils;
import org.chromium.base.lifetime.DestroyChecker;

class JankActivityTracker extends JankTrackerStateController
    implements ApplicationStatus.ActivityStateListener {
  private WeakReference<Activity> mActivityReference;
  private final DestroyChecker mDestroyChecker;
  private final ThreadUtils.ThreadChecker mThreadChecker;

  public JankActivityTracker(
      Activity context, FrameMetricsListener listener, JankReportingScheduler reportingScheduler) {
    super(listener, reportingScheduler);
    this.mThreadChecker = new ThreadUtils.ThreadChecker();
    this.mDestroyChecker = new DestroyChecker();
    this.mActivityReference = new WeakReference<>(context);
  }

  @Override
  public void initialize() {
    assertValidState();
    Activity activity = this.mActivityReference.get();
    if (activity != null) {
      ApplicationStatus.registerStateListenerForActivity(this, activity);
      int activityState = ApplicationStatus.getStateForActivity(activity);
      onActivityStateChange(activity, activityState);
      startMetricCollection(activity.getWindow());
    }
  }

  @Override
  public void destroy() {
    this.mThreadChecker.assertOnValidThread();
    ApplicationStatus.unregisterActivityStateListener(this);
    stopPeriodicReporting();
    Activity activity = this.mActivityReference.get();
    if (activity != null) {
      stopMetricCollection(activity.getWindow());
    }
    this.mDestroyChecker.destroy();
  }

  private void assertValidState() {
    this.mThreadChecker.assertOnValidThread();
    this.mDestroyChecker.checkNotDestroyed();
  }

  @Override
  public void onActivityStateChange(Activity activity, int newState) {
    assertValidState();
    switch (newState) {
      case 2:
      case 3:
        startPeriodicReporting();
        startMetricCollection(null);
        return;
      case 4:
        startPeriodicReporting();
        stopMetricCollection(null);
        return;
      case 5:
        stopPeriodicReporting();
        stopMetricCollection(null);
        return;
      default:
        return;
    }
  }
}
