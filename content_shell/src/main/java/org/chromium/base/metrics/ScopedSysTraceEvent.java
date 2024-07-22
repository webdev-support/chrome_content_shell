package org.chromium.base.metrics;

import android.os.Trace;

public class ScopedSysTraceEvent implements AutoCloseable {
  public static ScopedSysTraceEvent scoped(String name) {
    return new ScopedSysTraceEvent(name);
  }

  private ScopedSysTraceEvent(String name) {
    Trace.beginSection(name);
  }

  @Override   public void close() {
    Trace.endSection();
  }
}
