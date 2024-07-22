package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SharedWorkerConnector extends Interface {
  public static final Interface.Manager<SharedWorkerConnector, Proxy> MANAGER =
      SharedWorkerConnector_Internal.MANAGER;

  public interface Proxy extends SharedWorkerConnector, Interface.Proxy {}

  void connect(
      SharedWorkerInfo sharedWorkerInfo,
      SharedWorkerClient sharedWorkerClient,
      int i,
      MessagePortDescriptor messagePortDescriptor,
      BlobUrlToken blobUrlToken,
      long j);
}
