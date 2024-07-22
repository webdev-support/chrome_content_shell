package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface CdmService extends Interface {
  public static final Interface.Manager<CdmService, Proxy> MANAGER = CdmService_Internal.MANAGER;

  public interface Proxy extends CdmService, Interface.Proxy {}

  void createCdmFactory(
      InterfaceRequest<CdmFactory> interfaceRequest, FrameInterfaceFactory frameInterfaceFactory);
}
