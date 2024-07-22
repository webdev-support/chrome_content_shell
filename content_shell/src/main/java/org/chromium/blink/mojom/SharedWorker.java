package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SharedWorker extends Interface {
  public static final Interface.Manager<SharedWorker, Proxy> MANAGER =
      SharedWorker_Internal.MANAGER;

  public interface Proxy extends SharedWorker, Interface.Proxy {}

  void connect(int i, MessagePortDescriptor messagePortDescriptor);

  void terminate();
}
