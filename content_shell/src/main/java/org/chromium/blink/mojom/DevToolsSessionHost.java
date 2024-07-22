package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface DevToolsSessionHost extends Interface {
  public static final Interface.Manager<DevToolsSessionHost, Proxy> MANAGER =
      DevToolsSessionHost_Internal.MANAGER;

  public interface Proxy extends DevToolsSessionHost, Interface.Proxy {}

  void dispatchProtocolNotification(
      DevToolsMessage devToolsMessage, DevToolsSessionState devToolsSessionState);

  void dispatchProtocolResponse(
      DevToolsMessage devToolsMessage, int i, DevToolsSessionState devToolsSessionState);
}
