package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface EmbeddedWorkerInstanceClient extends Interface {
  public static final Interface.Manager<EmbeddedWorkerInstanceClient, Proxy> MANAGER =
      EmbeddedWorkerInstanceClient_Internal.MANAGER;

  public interface Proxy extends EmbeddedWorkerInstanceClient, Interface.Proxy {}

  void startWorker(EmbeddedWorkerStartParams embeddedWorkerStartParams);

  void stopWorker();
}
