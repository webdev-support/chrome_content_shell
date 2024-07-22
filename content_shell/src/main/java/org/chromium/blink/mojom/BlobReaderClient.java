package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface BlobReaderClient extends Interface {
  public static final Interface.Manager<BlobReaderClient, Proxy> MANAGER =
      BlobReaderClient_Internal.MANAGER;

  public interface Proxy extends BlobReaderClient, Interface.Proxy {}

  void onCalculatedSize(long j, long j2);

  void onComplete(int i, long j);
}
