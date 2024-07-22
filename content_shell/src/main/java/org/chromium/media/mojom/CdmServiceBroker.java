package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.FilePath;

public interface CdmServiceBroker extends Interface {
  public static final Interface.Manager<CdmServiceBroker, Proxy> MANAGER =
      CdmServiceBroker_Internal.MANAGER;

  public interface Proxy extends CdmServiceBroker, Interface.Proxy {}

  void getService(FilePath filePath, InterfaceRequest<CdmService> interfaceRequest);
}
