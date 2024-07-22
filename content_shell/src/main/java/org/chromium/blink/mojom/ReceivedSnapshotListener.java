package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ReceivedSnapshotListener extends Interface {
  public static final Interface.Manager<ReceivedSnapshotListener, Proxy> MANAGER =
      ReceivedSnapshotListener_Internal.MANAGER;

  public interface Proxy extends ReceivedSnapshotListener, Interface.Proxy {}

  void didReceiveSnapshotFile();
}
