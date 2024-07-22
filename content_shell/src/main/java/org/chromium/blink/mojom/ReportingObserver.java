package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ReportingObserver extends Interface {
  public static final Interface.Manager<ReportingObserver, Proxy> MANAGER =
      ReportingObserver_Internal.MANAGER;

  public interface Proxy extends ReportingObserver, Interface.Proxy {}

  void notify(Report report);
}
