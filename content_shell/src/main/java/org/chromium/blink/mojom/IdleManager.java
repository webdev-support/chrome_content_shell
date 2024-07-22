package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface IdleManager extends Interface {
  public static final Interface.Manager<IdleManager, Proxy> MANAGER = IdleManager_Internal.MANAGER;
  public static final int USER_INPUT_THRESHOLD_MS = 60000;

  public interface AddMonitor_Response {
    void call(int i, IdleState idleState);
  }

  public interface Proxy extends IdleManager, Interface.Proxy {}

  void addMonitor(IdleMonitor idleMonitor, AddMonitor_Response addMonitor_Response);
}
