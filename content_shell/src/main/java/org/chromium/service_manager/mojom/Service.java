package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.MessagePipeHandle;

public interface Service extends Interface {
  public static final Interface.Manager<Service, Proxy> MANAGER = Service_Internal.MANAGER;

  public interface OnBindInterface_Response {
    void call();
  }

  public interface OnStart_Response {
    void call(
        InterfaceRequest<Connector> interfaceRequest,
        AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported);
  }

  public interface Proxy extends Service, Interface.Proxy {}

  void createPackagedServiceInstance(
      Identity identity,
      InterfaceRequest<Service> interfaceRequest,
      ProcessMetadata processMetadata);

  void onBindInterface(
      BindSourceInfo bindSourceInfo,
      String str,
      MessagePipeHandle messagePipeHandle,
      OnBindInterface_Response onBindInterface_Response);

  void onStart(Identity identity, OnStart_Response onStart_Response);
}
