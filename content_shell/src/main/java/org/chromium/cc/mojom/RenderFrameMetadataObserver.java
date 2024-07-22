package org.chromium.cc.mojom;

import org.chromium.mojo.bindings.Interface;

public interface RenderFrameMetadataObserver extends Interface {
  public static final Manager<RenderFrameMetadataObserver, Proxy> MANAGER =
      RenderFrameMetadataObserver_Internal.MANAGER;

  public interface Proxy extends RenderFrameMetadataObserver, Interface.Proxy {}

  void reportAllFrameSubmissionsForTesting(boolean z);

  void updateRootScrollOffsetUpdateFrequency(int i);
}
