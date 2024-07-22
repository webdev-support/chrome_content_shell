package org.chromium.components.metrics;

public final class MetricsFeatures {
  public static final String FLUSH_PERSISTENT_SYSTEM_PROFILE_ON_WRITE =
      "FlushPersistentSystemProfileOnWrite";
  public static final String METRICS_LOG_TRIMMING = "MetricsLogTrimming";
  public static final String METRICS_SERVICE_ALLOW_EARLY_LOG_CLOSE =
      "MetricsServiceAllowEarlyLogClose";
  public static final String METRICS_SERVICE_DELTA_SNAPSHOT_IN_BG =
      "MetricsServiceDeltaSnapshotInBg";
  public static final String REPORTING_SERVICE_ALWAYS_FLUSH = "ReportingServiceAlwaysFlush";
  public static final String STRUCTURED_METRICS = "EnableStructuredMetrics";

  private MetricsFeatures() {}
}
