package org.chromium.base.jank_tracker;

public class PlaceholderJankTracker implements JankTracker {
  @Override
  public void startTrackingScenario(JankScenario scenario) {}

  @Override
  public void finishTrackingScenario(JankScenario scenario) {}

  @Override
  public void finishTrackingScenario(JankScenario scenario, long endScenarioTimeNs) {}

  @Override
  public void destroy() {}
}
