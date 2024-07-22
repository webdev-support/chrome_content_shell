package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface DomStorageClient extends Interface {
  public static final Interface.Manager<DomStorageClient, Proxy> MANAGER =
      DomStorageClient_Internal.MANAGER;

  public interface Proxy extends DomStorageClient, Interface.Proxy {}

  void resetStorageAreaAndNamespaceConnections();
}
