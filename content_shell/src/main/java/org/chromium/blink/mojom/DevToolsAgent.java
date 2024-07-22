package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Point;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface DevToolsAgent extends Interface {
  public static final Interface.Manager<DevToolsAgent, Proxy> MANAGER =
      DevToolsAgent_Internal.MANAGER;

  public interface Proxy extends DevToolsAgent, Interface.Proxy {}

  public interface ReportChildTargets_Response {
    void call();
  }

  void attachDevToolsSession(
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported,
      InterfaceRequest<DevToolsSession> interfaceRequest,
      DevToolsSessionState devToolsSessionState,
      boolean z,
      boolean z2,
      String str,
      boolean z3);

  void inspectElement(Point point);

  void reportChildTargets(
      boolean z, boolean z2, ReportChildTargets_Response reportChildTargets_Response);
}
