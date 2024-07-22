package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface MediaService extends Interface {
  public static final Interface.Manager<MediaService, Proxy> MANAGER =
      MediaService_Internal.MANAGER;

  public interface Proxy extends MediaService, Interface.Proxy {}

  void createInterfaceFactory(
      InterfaceRequest<InterfaceFactory> interfaceRequest,
      FrameInterfaceFactory frameInterfaceFactory);
}
