package org.chromium.base.jank_tracker;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.atomic.AtomicBoolean;

public class JankReportingScheduler {
  private static final long PERIODIC_METRIC_DELAY_MS = 5000;
  private final FrameMetricsStore mFrameMetricsStore;
  private final Runnable mPeriodicMetricReporter =
      new Runnable() {
        @Override
        public void run() {
          JankReportingScheduler.this.finishTrackingScenario(JankScenario.PERIODIC_REPORTING);
          if (JankReportingScheduler.this.mIsPeriodicReporterLooping.get()) {
            JankReportingScheduler.this.startTrackingScenario(JankScenario.PERIODIC_REPORTING);
            LazyHolder.HANDLER.postDelayed(
                JankReportingScheduler.this.mPeriodicMetricReporter,
                JankReportingScheduler.PERIODIC_METRIC_DELAY_MS);
          }
        }
      };
  private final AtomicBoolean mIsPeriodicReporterLooping = new AtomicBoolean(false);

  public JankReportingScheduler(FrameMetricsStore frameMetricsStore) {
    this.mFrameMetricsStore = frameMetricsStore;
    LazyHolder.HANDLER.post(
        new Runnable() {
          @Override
          public void run() {
            JankReportingScheduler.this.mFrameMetricsStore.initialize();
          }
        });
  }

  public static class LazyHolder {
    private static final Handler HANDLER;
    private static final HandlerThread HANDLER_THREAD;

    private LazyHolder() {}

    static {
      HandlerThread handlerThread = new HandlerThread("Jank-Tracker");
      HANDLER_THREAD = handlerThread;
      handlerThread.start();
      HANDLER = new Handler(handlerThread.getLooper());
    }
  }

  public void startTrackingScenario(JankScenario scenario) {
    LazyHolder.HANDLER.post(
        new JankReportingRunnable(
            this.mFrameMetricsStore, scenario, true, LazyHolder.HANDLER, null));
  }

  public void finishTrackingScenario(JankScenario scenario) {
    finishTrackingScenario(scenario, -1L);
  }

  public void finishTrackingScenario(JankScenario scenario, long endScenarioTimeNs) {
    finishTrackingScenario(scenario, JankEndScenarioTime.endAt(endScenarioTimeNs));
  }

  public void finishTrackingScenario(JankScenario scenario, JankEndScenarioTime endScenarioTime) {
    JankReportingRunnable runnable =
        new JankReportingRunnable(
            this.mFrameMetricsStore, scenario, false, LazyHolder.HANDLER, endScenarioTime);
    LazyHolder.HANDLER.post(runnable);
  }

  public Handler getOrCreateHandler() {
    return LazyHolder.HANDLER;
  }

  public void startReportingPeriodicMetrics() {
    if (this.mIsPeriodicReporterLooping.getAndSet(true)) {
      return;
    }
    startTrackingScenario(JankScenario.PERIODIC_REPORTING);
    LazyHolder.HANDLER.postDelayed(this.mPeriodicMetricReporter, PERIODIC_METRIC_DELAY_MS);
  }

  public void stopReportingPeriodicMetrics() {
    if (!this.mIsPeriodicReporterLooping.getAndSet(false)) {
      return;
    }
    LazyHolder.HANDLER.removeCallbacks(this.mPeriodicMetricReporter);
    LazyHolder.HANDLER.post(this.mPeriodicMetricReporter);
  }
}
