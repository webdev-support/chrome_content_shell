package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ReportingApiObserver extends Interface {
  public static final Interface.Manager<ReportingApiObserver, Proxy> MANAGER =
      ReportingApiObserver_Internal.MANAGER;

  public interface Proxy extends ReportingApiObserver, Interface.Proxy {}

  void onEndpointsUpdatedForOrigin(ReportingApiEndpoint[] reportingApiEndpointArr);

  void onReportAdded(ReportingApiReport reportingApiReport);

  void onReportUpdated(ReportingApiReport reportingApiReport);
}
