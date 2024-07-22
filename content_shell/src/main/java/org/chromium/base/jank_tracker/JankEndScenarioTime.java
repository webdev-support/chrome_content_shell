package org.chromium.base.jank_tracker;

public final class JankEndScenarioTime {
  public final long endScenarioTimeNs;
  public final long timeoutDelayMs = 100;

  public static JankEndScenarioTime endAt(long uptimeNanos) {
    if (uptimeNanos <= 0) {
      return null;
    }
    return new JankEndScenarioTime(uptimeNanos);
  }

  private JankEndScenarioTime(long uptimeNanos) {
    this.endScenarioTimeNs = uptimeNanos;
  }
}
