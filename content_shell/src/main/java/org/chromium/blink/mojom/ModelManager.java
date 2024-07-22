package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface ModelManager extends Interface {
  public static final Interface.Manager<ModelManager, Proxy> MANAGER =
      ModelManager_Internal.MANAGER;

  public interface CanCreateGenericSession_Response {
    void call(boolean z);
  }

  public interface CreateGenericSession_Response {
    void call(boolean z);
  }

  public interface Proxy extends ModelManager, Interface.Proxy {}

  void canCreateGenericSession(CanCreateGenericSession_Response canCreateGenericSession_Response);

  void createGenericSession(
      InterfaceRequest<ModelGenericSession> interfaceRequest,
      CreateGenericSession_Response createGenericSession_Response);
}
