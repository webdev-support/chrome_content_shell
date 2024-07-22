package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface IdleMonitor extends Interface {
  public static final Interface.Manager<IdleMonitor, Proxy> MANAGER = IdleMonitor_Internal.MANAGER;

  public interface Proxy extends IdleMonitor, Interface.Proxy {}

  void update(IdleState idleState, boolean z);
}
