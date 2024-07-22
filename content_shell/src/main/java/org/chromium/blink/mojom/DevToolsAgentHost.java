package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.mojom.Url;

public interface DevToolsAgentHost extends Interface {
  public static final Interface.Manager<DevToolsAgentHost, Proxy> MANAGER =
      DevToolsAgentHost_Internal.MANAGER;

  public interface Proxy extends DevToolsAgentHost, Interface.Proxy {}

  void bringToForeground();

  void childTargetCreated(
      DevToolsAgent devToolsAgent,
      InterfaceRequest<DevToolsAgentHost> interfaceRequest,
      Url url,
      String str,
      UnguessableToken unguessableToken,
      boolean z,
      int i);

  void mainThreadDebuggerPaused();

  void mainThreadDebuggerResumed();
}
