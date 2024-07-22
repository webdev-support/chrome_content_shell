package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface WorkletDevToolsHost extends Interface {
  public static final Interface.Manager<WorkletDevToolsHost, Proxy> MANAGER =
      WorkletDevToolsHost_Internal.MANAGER;

  public interface Proxy extends WorkletDevToolsHost, Interface.Proxy {}

  void onReadyForInspection(
      DevToolsAgent devToolsAgent, InterfaceRequest<DevToolsAgentHost> interfaceRequest);
}
