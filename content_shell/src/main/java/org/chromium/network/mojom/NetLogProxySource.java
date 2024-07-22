package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface NetLogProxySource extends Interface {
  public static final Interface.Manager<NetLogProxySource, Proxy> MANAGER =
      NetLogProxySource_Internal.MANAGER;

  public interface Proxy extends NetLogProxySource, Interface.Proxy {}

  void updateCaptureModes(int i);
}
