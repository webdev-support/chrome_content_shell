package org.chromium.base.metrics;

import org.chromium.base.TimeUtils;

public class RecordUserAction {
  public static void record(String action) {
    UmaRecorderHolder.get().recordUserAction(action, TimeUtils.elapsedRealtimeMillis());
  }
}
