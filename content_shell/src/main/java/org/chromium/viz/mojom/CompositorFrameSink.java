package org.chromium.viz.mojom;

import org.chromium.gpu.mojom.Mailbox;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;

public interface CompositorFrameSink extends Interface {
  public static final Interface.Manager<CompositorFrameSink, Proxy> MANAGER =
      CompositorFrameSink_Internal.MANAGER;

  public interface Proxy extends CompositorFrameSink, Interface.Proxy {}

  public interface SubmitCompositorFrameSync_Response {
    void call(ReturnedResource[] returnedResourceArr);
  }

  void bindLayerContext(PendingLayerContext pendingLayerContext);

  void didAllocateSharedBitmap(
      ReadOnlySharedMemoryRegion readOnlySharedMemoryRegion, Mailbox mailbox);

  void didDeleteSharedBitmap(Mailbox mailbox);

  void didNotProduceFrame(BeginFrameAck beginFrameAck);

  void initializeCompositorFrameSinkType(int i);

  void setAutoNeedsBeginFrame();

  void setNeedsBeginFrame(boolean z);

  void setThreadIds(int[] iArr);

  void setWantsAnimateOnlyBeginFrames();

  void setWantsBeginFrameAcks();

  void submitCompositorFrame(
      LocalSurfaceId localSurfaceId,
      CompositorFrame compositorFrame,
      HitTestRegionList hitTestRegionList,
      long j);

  void submitCompositorFrameSync(
      LocalSurfaceId localSurfaceId,
      CompositorFrame compositorFrame,
      HitTestRegionList hitTestRegionList,
      long j,
      SubmitCompositorFrameSync_Response submitCompositorFrameSync_Response);
}
