package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface SharedWorkerHost extends Interface {
  public static final Interface.Manager<SharedWorkerHost, Proxy> MANAGER =
      SharedWorkerHost_Internal.MANAGER;

  public interface Proxy extends SharedWorkerHost, Interface.Proxy {}

  void onConnected(int i);

  void onContextClosed();

  void onFeatureUsed(int i);

  void onReadyForInspection(
      DevToolsAgent devToolsAgent, InterfaceRequest<DevToolsAgentHost> interfaceRequest);

  void onScriptLoadFailed(String str);
}
