package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface FrameResourceReleaser extends Interface {
  public static final Interface.Manager<FrameResourceReleaser, Proxy> MANAGER =
      FrameResourceReleaser_Internal.MANAGER;

  public interface Proxy extends FrameResourceReleaser, Interface.Proxy {}
}
