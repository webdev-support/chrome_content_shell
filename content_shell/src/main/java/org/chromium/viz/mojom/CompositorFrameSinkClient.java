package org.chromium.viz.mojom;

import java.util.Map;
import org.chromium.mojo.bindings.Interface;

public interface CompositorFrameSinkClient extends Interface {
  public static final Interface.Manager<CompositorFrameSinkClient, Proxy> MANAGER =
      CompositorFrameSinkClient_Internal.MANAGER;

  public interface Proxy extends CompositorFrameSinkClient, Interface.Proxy {}

  void didReceiveCompositorFrameAck(ReturnedResource[] returnedResourceArr);

  void onBeginFrame(
      BeginFrameArgs beginFrameArgs,
      Map<Integer, FrameTimingDetails> map,
      boolean z,
      ReturnedResource[] returnedResourceArr);

  void onBeginFramePausedChanged(boolean z);

  void onCompositorFrameTransitionDirectiveProcessed(int i);

  void onSurfaceEvicted(LocalSurfaceId localSurfaceId);

  void reclaimResources(ReturnedResource[] returnedResourceArr);
}
