package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface P2pTrustedSocketManagerClient extends Interface {
  public static final Interface.Manager<P2pTrustedSocketManagerClient, Proxy> MANAGER =
      P2pTrustedSocketManagerClient_Internal.MANAGER;

  public interface Proxy extends P2pTrustedSocketManagerClient, Interface.Proxy {}

  void dumpPacket(byte[] bArr, long j, boolean z);

  void invalidSocketPortRangeRequested();
}
