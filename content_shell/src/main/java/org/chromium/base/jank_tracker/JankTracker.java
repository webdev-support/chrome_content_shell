package org.chromium.base.jank_tracker;

public interface JankTracker {
  void destroy();

  void finishTrackingScenario(JankScenario jankScenario);

  void finishTrackingScenario(JankScenario jankScenario, long j);

  void startTrackingScenario(JankScenario jankScenario);
}
