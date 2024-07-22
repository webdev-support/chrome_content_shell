package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SynchronousCompositorHost extends Interface {
  public static final Interface.Manager<SynchronousCompositorHost, Proxy> MANAGER =
      SynchronousCompositorHost_Internal.MANAGER;

  public interface Proxy extends SynchronousCompositorHost, Interface.Proxy {}

  void layerTreeFrameSinkCreated();

  void setNeedsBeginFrames(boolean z);

  void updateState(SyncCompositorCommonRendererParams syncCompositorCommonRendererParams);
}
