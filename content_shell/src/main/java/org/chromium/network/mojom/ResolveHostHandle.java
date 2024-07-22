package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ResolveHostHandle extends Interface {
  public static final Interface.Manager<ResolveHostHandle, Proxy> MANAGER =
      ResolveHostHandle_Internal.MANAGER;

  public interface Proxy extends ResolveHostHandle, Interface.Proxy {}

  void cancel(int i);
}
