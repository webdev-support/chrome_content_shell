package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.Interface;

public interface LayerContext extends Interface {
  public static final Interface.Manager<LayerContext, Proxy> MANAGER =
      LayerContext_Internal.MANAGER;

  public interface Proxy extends LayerContext, Interface.Proxy {}

  void commit(LayerTreeUpdate layerTreeUpdate);

  void setTargetLocalSurfaceId(LocalSurfaceId localSurfaceId);

  void setVisible(boolean z);
}
