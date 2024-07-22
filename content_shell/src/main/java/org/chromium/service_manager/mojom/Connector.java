package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.MessagePipeHandle;

public interface Connector extends Interface {
  public static final Interface.Manager<Connector, Proxy> MANAGER = Connector_Internal.MANAGER;

  public interface BindInterface_Response {
    void call(int i, Identity identity);
  }

  public interface Proxy extends Connector, Interface.Proxy {}

  public interface QueryService_Response {
    void call(ServiceInfo serviceInfo);
  }

  public interface RegisterServiceInstance_Response {
    void call(int i);
  }

  public interface WarmService_Response {
    void call(int i, Identity identity);
  }

  void bindInterface(
      ServiceFilter serviceFilter,
      String str,
      MessagePipeHandle messagePipeHandle,
      int i,
      BindInterface_Response bindInterface_Response);

  void clone(InterfaceRequest<Connector> interfaceRequest);

  void queryService(String str, QueryService_Response queryService_Response);

  void registerServiceInstance(
      Identity identity,
      MessagePipeHandle messagePipeHandle,
      InterfaceRequest<ProcessMetadata> interfaceRequest,
      RegisterServiceInstance_Response registerServiceInstance_Response);

  void warmService(ServiceFilter serviceFilter, WarmService_Response warmService_Response);
}
