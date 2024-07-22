package org.chromium.blink.mojom;

import org.chromium.gpu.mojom.SyncToken;
import org.chromium.mojo.bindings.Interface;

public interface ImageReleaseCallback extends Interface {
  public static final Interface.Manager<ImageReleaseCallback, Proxy> MANAGER =
      ImageReleaseCallback_Internal.MANAGER;

  public interface Proxy extends ImageReleaseCallback, Interface.Proxy {}

  void release(SyncToken syncToken);
}
