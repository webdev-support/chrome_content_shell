package org.chromium.base.jank_tracker;

import android.view.Window;
import org.chromium.base.Log;

public class JankTrackerStateController {
  private static final String TAG = "JankTracker";
  protected final FrameMetricsListener mFrameMetricsListener;
  protected final JankReportingScheduler mReportingScheduler;

  public JankTrackerStateController(
      FrameMetricsListener listener, JankReportingScheduler scheduler) {
    this.mFrameMetricsListener = listener;
    this.mReportingScheduler = scheduler;
  }

  public void startPeriodicReporting() {
    this.mReportingScheduler.startReportingPeriodicMetrics();
  }

  public void stopPeriodicReporting() {
    this.mReportingScheduler.stopReportingPeriodicMetrics();
  }

  public void startMetricCollection(Window window) {
    this.mFrameMetricsListener.setIsListenerRecording(true);
    if (window != null) {
      window.addOnFrameMetricsAvailableListener(
          this.mFrameMetricsListener, this.mReportingScheduler.getOrCreateHandler());
    }
  }

  public void stopMetricCollection(Window window) {
    this.mFrameMetricsListener.setIsListenerRecording(false);
    if (window != null) {
      try {
        window.removeOnFrameMetricsAvailableListener(this.mFrameMetricsListener);
      } catch (IllegalArgumentException e) {
        Log.e(
            TAG, "Could not remove listener %s from window %s", this.mFrameMetricsListener, window);
      }
    }
  }

  public void initialize() {}

  public void destroy() {}
}
