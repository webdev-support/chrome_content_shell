package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ProgressClient extends Interface {
  public static final Interface.Manager<ProgressClient, Proxy> MANAGER =
      ProgressClient_Internal.MANAGER;

  public interface Proxy extends ProgressClient, Interface.Proxy {}

  void onProgress(long j);
}
