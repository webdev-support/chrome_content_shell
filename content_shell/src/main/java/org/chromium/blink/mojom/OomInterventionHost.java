package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface OomInterventionHost extends Interface {
  public static final Interface.Manager<OomInterventionHost, Proxy> MANAGER =
      OomInterventionHost_Internal.MANAGER;

  public interface Proxy extends OomInterventionHost, Interface.Proxy {}

  void onHighMemoryUsage();
}
