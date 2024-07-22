package org.chromium.base.jank_tracker;

import com.example.chromium_content_view.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.chromium.base.ThreadUtils;
import org.chromium.base.TimeUtils;
import org.chromium.base.TraceEvent;

public class FrameMetricsStore {
  private static final long TRACE_EVENT_TRACK_ID = 84186319646187624L;
  private final ArrayList<Integer> mNumMissedVsyncs;
  private final HashMap<JankScenario, Long> mPendingStartTimestampNs;
  private final HashMap<JankScenario, Long> mScenarioPreviousFrameTimestampNs;
  private final ArrayList<Long> mTimestampsNs;
  private final ArrayList<Long> mTotalDurationsNs;
  private final ThreadUtils.ThreadChecker mThreadChecker = new ThreadUtils.ThreadChecker();
  private long mMaxTimestamp = -1;

  public FrameMetricsStore() {
    ArrayList<Long> arrayList = new ArrayList<>();
    this.mTimestampsNs = arrayList;
    ArrayList<Long> arrayList2 = new ArrayList<>();
    this.mTotalDurationsNs = arrayList2;
    ArrayList<Integer> arrayList3 = new ArrayList<>();
    this.mNumMissedVsyncs = arrayList3;
    this.mScenarioPreviousFrameTimestampNs = new HashMap<>();
    this.mPendingStartTimestampNs = new HashMap<>();
    arrayList.add(0L);
    arrayList2.add(0L);
    arrayList3.add(0);
  }

  public static String scenarioToString(int scenario) {
    switch (scenario) {
      case 1:
        return "Total";
      case 2:
        return "OmniboxFocus";
      case 3:
        return "NewTabPage";
      case 4:
        return "Startup";
      case 5:
        return "TabSwitcher";
      case 6:
        return "OpenLinkInNewTab";
      case 7:
        return "StartSurfaceHomepage";
      case 8:
        return "StartSurfaceTabSwitcher";
      case 9:
        return "FeedScrolling";
      case 10:
        return "WebviewScrolling";
      default:
        throw new IllegalArgumentException("Invalid scenario value");
    }
  }

  public void initialize() {
    this.mThreadChecker.resetThreadId();
  }

  public void addFrameMeasurement(
      long totalDurationNs, int numMissedVsyncs, long frameStartVsyncTs) {
    this.mThreadChecker.assertOnValidThread();
    this.mTotalDurationsNs.add(Long.valueOf(totalDurationNs));
    this.mNumMissedVsyncs.add(Integer.valueOf(numMissedVsyncs));
    this.mTimestampsNs.add(Long.valueOf(frameStartVsyncTs));
    this.mMaxTimestamp = frameStartVsyncTs;
  }

  public void startTrackingScenario(JankScenario scenario) {
    TraceEvent e = TraceEvent.scoped("startTrackingScenario: " + scenarioToString(scenario.type()));
    try {
      this.mThreadChecker.assertOnValidThread();
      if (this.mScenarioPreviousFrameTimestampNs.containsKey(scenario)) {
        this.mPendingStartTimestampNs.put(
            scenario,
            Long.valueOf(TimeUtils.uptimeMillis() * TimeUtils.NANOSECONDS_PER_MILLISECOND));
        if (e != null) {
          e.close();
          return;
        }
        return;
      }
      TraceEvent.startAsync(
          "JankCUJ:" + scenarioToString(scenario.type()), scenario.type() + TRACE_EVENT_TRACK_ID);
      ArrayList<Long> arrayList = this.mTimestampsNs;
      Long startingTimestamp = arrayList.get(arrayList.size() - 1);
      this.mScenarioPreviousFrameTimestampNs.put(scenario, startingTimestamp);
      if (e != null) {
        e.close();
      }
    } catch (Throwable th) {
      if (e != null) {
        try {
          e.close();
        } catch (Throwable th2) {
          th.addSuppressed(th2);
        }
      }
      throw th;
    }
  }

  public boolean hasReceivedMetricsPast(long endScenarioTimeNs) {
    this.mThreadChecker.assertOnValidThread();
    return this.mMaxTimestamp > endScenarioTimeNs;
  }

  public JankMetrics stopTrackingScenario(JankScenario scenario) {
    return stopTrackingScenario(scenario, -1L);
  }

  public JankMetrics stopTrackingScenario(JankScenario scenario, long endScenarioTimeNs) {
    TraceEvent e =
        TraceEvent.scoped(
            "finishTrackingScenario: " + scenarioToString(scenario.type()),
            Long.toString(endScenarioTimeNs));
    try {
      this.mThreadChecker.assertOnValidThread();
      TraceEvent.finishAsync(
          "JankCUJ:" + scenarioToString(scenario.type()), scenario.type() + TRACE_EVENT_TRACK_ID);
      Long previousFrameTimestamp = this.mScenarioPreviousFrameTimestampNs.remove(scenario);
      if (previousFrameTimestamp == null) {
        removeUnusedFrames();
        JankMetrics jankMetrics = new JankMetrics();
        if (e != null) {
          e.close();
        }
        return jankMetrics;
      }
      int startingIndex = this.mTimestampsNs.indexOf(previousFrameTimestamp) + 1;
      if (startingIndex >= this.mTimestampsNs.size()) {
        JankMetrics jankMetrics2 = new JankMetrics();
        if (e != null) {
          e.close();
        }
        return jankMetrics2;
      }
      int endingIndex = this.mTimestampsNs.size();
      if (endScenarioTimeNs > 0) {
        int endingIndex2 =
            Collections.binarySearch(this.mTimestampsNs, Long.valueOf(endScenarioTimeNs));
        if (endingIndex2 < 0) {
          endingIndex = (endingIndex2 + 1) * (-1);
        } else {
          endingIndex = Math.min(endingIndex2 + 1, this.mTimestampsNs.size());
        }
        if (endingIndex <= startingIndex) {
          TraceEvent.instant("FrameMetricsStore invalid endScenarioTimeNs");
          endingIndex = this.mTimestampsNs.size();
        }
      }
      JankMetrics jankMetrics3 =
          convertArraysToJankMetrics(
              this.mTimestampsNs.subList(startingIndex, endingIndex),
              this.mTotalDurationsNs.subList(startingIndex, endingIndex),
              this.mNumMissedVsyncs.subList(startingIndex, endingIndex));
      removeUnusedFrames();
      Long pendingStartTimestampNs = this.mPendingStartTimestampNs.remove(scenario);
      if (pendingStartTimestampNs != null
          && pendingStartTimestampNs.longValue() > endScenarioTimeNs) {
        startTrackingScenario(scenario);
      }
      if (e != null) {
        e.close();
      }
      return jankMetrics3;
    } catch (Throwable th) {
      if (e != null) {
        try {
          e.close();
        } catch (Throwable th2) {
          th.addSuppressed(th2);
        }
      }
      throw th;
    }
  }

  private void removeUnusedFrames() {
    if (this.mScenarioPreviousFrameTimestampNs.isEmpty()) {
      TraceEvent.instant("removeUnusedFrames", Long.toString(this.mTimestampsNs.size()));
      ArrayList<Long> arrayList = this.mTimestampsNs;
      arrayList.subList(1, arrayList.size()).clear();
      ArrayList<Long> arrayList2 = this.mTotalDurationsNs;
      arrayList2.subList(1, arrayList2.size()).clear();
      ArrayList<Integer> arrayList3 = this.mNumMissedVsyncs;
      arrayList3.subList(1, arrayList3.size()).clear();
      return;
    }
    long firstUsedTimestamp = findFirstUsedTimestamp();
    if (firstUsedTimestamp == 0) {
      return;
    }
    int firstUsedIndex = this.mTimestampsNs.indexOf(Long.valueOf(firstUsedTimestamp));
    if (firstUsedIndex == -1) {
      if (BuildConfig.ENABLE_ASSERTS) {
        throw new IllegalStateException("Timestamp for tracked scenario not found");
      }
      return;
    }
    TraceEvent.instant("removeUnusedFrames", Long.toString(firstUsedIndex));
    this.mTimestampsNs.subList(1, firstUsedIndex).clear();
    this.mTotalDurationsNs.subList(1, firstUsedIndex).clear();
    this.mNumMissedVsyncs.subList(1, firstUsedIndex).clear();
  }

  private long findFirstUsedTimestamp() {
    long firstTimestamp = Long.MAX_VALUE;
    for (Long l : this.mScenarioPreviousFrameTimestampNs.values()) {
      long timestamp = l.longValue();
      if (timestamp < firstTimestamp) {
        firstTimestamp = timestamp;
      }
    }
    return firstTimestamp;
  }

  private JankMetrics convertArraysToJankMetrics(
      List<Long> longTimestampsNs, List<Long> longDurations, List<Integer> intNumMissedVsyncs) {
    long[] timestamps = new long[longTimestampsNs.size()];
    for (int i = 0; i < longTimestampsNs.size(); i++) {
      timestamps[i] = longTimestampsNs.get(i).longValue();
    }
    int i2 = longDurations.size();
    long[] durations = new long[i2];
    for (int i3 = 0; i3 < longDurations.size(); i3++) {
      durations[i3] = longDurations.get(i3).longValue();
    }
    int i4 = intNumMissedVsyncs.size();
    int[] numMissedVsyncs = new int[i4];
    for (int i5 = 0; i5 < intNumMissedVsyncs.size(); i5++) {
      numMissedVsyncs[i5] = intNumMissedVsyncs.get(i5).intValue();
    }
    JankMetrics jankMetrics = new JankMetrics(timestamps, durations, numMissedVsyncs);
    return jankMetrics;
  }
}
