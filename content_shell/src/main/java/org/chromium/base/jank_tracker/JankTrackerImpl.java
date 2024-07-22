package org.chromium.base.jank_tracker;

import android.app.Activity;
import android.os.Build;
import java.lang.ref.WeakReference;
import org.chromium.base.task.PostTask;

public class JankTrackerImpl implements JankTracker {
  private static final boolean IS_TRACKING_ENABLED;
  private JankTrackerStateController mController;
  private boolean mDestroyed;
  private boolean mIsInitialized;
  private JankReportingScheduler mReportingScheduler;

  static {
    IS_TRACKING_ENABLED = Build.VERSION.SDK_INT >= 31;
  }

  public JankTrackerImpl(Activity activity, int constructionDelayMs) {
    final WeakReference<Activity> ref = new WeakReference<>(activity);
    Runnable init =
        new Runnable() {
          @Override
          public void run() {
            Activity innerActivity = (Activity) ref.get();
            if (JankTrackerImpl.this.mDestroyed
                || innerActivity == null
                || innerActivity.isDestroyed()) {
              return;
            }
            FrameMetricsStore metricsStore = new FrameMetricsStore();
            if (!JankTrackerImpl.this.constructInternalPreController(
                new JankReportingScheduler(metricsStore))) {
              return;
            }
            JankTrackerImpl.this.constructInternalFinal(
                new JankActivityTracker(
                    innerActivity,
                    new FrameMetricsListener(metricsStore),
                    JankTrackerImpl.this.mReportingScheduler));
          }
        };
    if (constructionDelayMs <= 0) {
      init.run();
    } else {
      PostTask.postDelayedTask(7, init, constructionDelayMs);
    }
  }

  public JankTrackerImpl(JankTrackerStateController controller) {
    if (constructInternalPreController(controller.mReportingScheduler)) {
      constructInternalFinal(controller);
    }
  }

  public boolean constructInternalPreController(JankReportingScheduler scheduler) {
    if (!IS_TRACKING_ENABLED) {
      this.mReportingScheduler = null;
      this.mController = null;
      return false;
    }
    this.mReportingScheduler = scheduler;
    return true;
  }

  public void constructInternalFinal(JankTrackerStateController controller) {
    this.mController = controller;
    controller.initialize();
    this.mIsInitialized = true;
  }

  @Override
  public void startTrackingScenario(JankScenario scenario) {
    if (!IS_TRACKING_ENABLED || !this.mIsInitialized) {
      return;
    }
    this.mReportingScheduler.startTrackingScenario(scenario);
  }

  @Override
  public void finishTrackingScenario(JankScenario scenario) {
    finishTrackingScenario(scenario, -1L);
  }

  @Override
  public void finishTrackingScenario(JankScenario scenario, long endScenarioTimeNs) {
    if (!IS_TRACKING_ENABLED || !this.mIsInitialized) {
      return;
    }
    this.mReportingScheduler.finishTrackingScenario(scenario, endScenarioTimeNs);
  }

  @Override
  public void destroy() {
    this.mDestroyed = true;
    if (!IS_TRACKING_ENABLED || !this.mIsInitialized) {
      return;
    }
    this.mController.destroy();
  }
}
