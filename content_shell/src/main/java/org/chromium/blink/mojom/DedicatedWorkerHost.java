package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface DedicatedWorkerHost extends Interface {
  public static final Interface.Manager<DedicatedWorkerHost, Proxy> MANAGER =
      DedicatedWorkerHost_Internal.MANAGER;

  public interface Proxy extends DedicatedWorkerHost, Interface.Proxy {}
}
