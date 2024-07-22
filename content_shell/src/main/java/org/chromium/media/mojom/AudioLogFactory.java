package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface AudioLogFactory extends Interface {
  public static final Interface.Manager<AudioLogFactory, Proxy> MANAGER =
      AudioLogFactory_Internal.MANAGER;

  public interface Proxy extends AudioLogFactory, Interface.Proxy {}

  void createAudioLog(int i, int i2, InterfaceRequest<AudioLog> interfaceRequest);
}
