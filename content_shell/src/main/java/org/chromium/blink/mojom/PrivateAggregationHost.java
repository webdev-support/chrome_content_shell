package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PrivateAggregationHost extends Interface {
  public static final Interface.Manager<PrivateAggregationHost, Proxy> MANAGER =
      PrivateAggregationHost_Internal.MANAGER;

  public interface Proxy extends PrivateAggregationHost, Interface.Proxy {}

  void contributeToHistogram(
      AggregatableReportHistogramContribution[] aggregatableReportHistogramContributionArr);

  void enableDebugMode(DebugKey debugKey);
}
