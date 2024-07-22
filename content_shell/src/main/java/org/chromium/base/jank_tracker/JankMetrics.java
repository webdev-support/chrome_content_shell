package org.chromium.base.jank_tracker;

class JankMetrics {
  public final long[] durationsNs;
  public final boolean[] isJanky;
  public final int[] missedVsyncs;
  public final long[] timestampsNs;

  public JankMetrics() {
    this.timestampsNs = new long[0];
    this.durationsNs = new long[0];
    this.missedVsyncs = new int[0];
    this.isJanky = new boolean[0];
  }

  public JankMetrics(long[] timestampsNs, long[] durationsNs, int[] missedVsyncs) {
    this.timestampsNs = timestampsNs;
    this.durationsNs = durationsNs;
    this.missedVsyncs = missedVsyncs;
    this.isJanky = new boolean[0];
  }
}
