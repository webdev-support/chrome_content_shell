package org.chromium.viz.mojom;

import org.chromium.gpu.mojom.SyncToken;
import org.chromium.mojo.bindings.Interface;

public interface TextureReleaser extends Interface {
  public static final Interface.Manager<TextureReleaser, Proxy> MANAGER =
      TextureReleaser_Internal.MANAGER;

  public interface Proxy extends TextureReleaser, Interface.Proxy {}

  void release(SyncToken syncToken, boolean z);
}
