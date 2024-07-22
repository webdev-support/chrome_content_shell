package org.chromium.cc.mojom;

import org.chromium.gfx.mojom.PointF;
import org.chromium.mojo.bindings.Interface;

public interface RenderFrameMetadataObserverClient extends Interface {
  public static final Manager<RenderFrameMetadataObserverClient, Proxy> MANAGER =
      RenderFrameMetadataObserverClient_Internal.MANAGER;

  public interface Proxy extends RenderFrameMetadataObserverClient, Interface.Proxy {}

  void onFrameSubmissionForTesting(int i);

  void onRenderFrameMetadataChanged(int i, RenderFrameMetadata renderFrameMetadata);

  void onRootScrollOffsetChanged(PointF pointF);
}
