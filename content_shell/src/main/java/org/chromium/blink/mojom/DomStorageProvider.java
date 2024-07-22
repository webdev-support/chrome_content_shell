package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface DomStorageProvider extends Interface {
  public static final Interface.Manager<DomStorageProvider, Proxy> MANAGER =
      DomStorageProvider_Internal.MANAGER;

  public interface Proxy extends DomStorageProvider, Interface.Proxy {}

  void bindDomStorage(
      InterfaceRequest<DomStorage> interfaceRequest, DomStorageClient domStorageClient);
}
