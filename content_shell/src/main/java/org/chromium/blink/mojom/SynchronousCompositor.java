package org.chromium.blink.mojom;

import java.util.Map;
import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.PointF;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.WritableSharedMemoryRegion;
import org.chromium.viz.mojom.BeginFrameArgs;
import org.chromium.viz.mojom.CompositorFrame;
import org.chromium.viz.mojom.CompositorFrameMetadata;
import org.chromium.viz.mojom.FrameTimingDetails;
import org.chromium.viz.mojom.HitTestRegionList;
import org.chromium.viz.mojom.LocalSurfaceId;
import org.chromium.viz.mojom.ReturnedResource;

public interface SynchronousCompositor extends Interface {
  public static final Interface.Manager<SynchronousCompositor, Proxy> MANAGER =
      SynchronousCompositor_Internal.MANAGER;

  public interface DemandDrawHw_Response {
    void call(
        SyncCompositorCommonRendererParams syncCompositorCommonRendererParams,
        int i,
        int i2,
        LocalSurfaceId localSurfaceId,
        CompositorFrame compositorFrame,
        HitTestRegionList hitTestRegionList);
  }

  public interface DemandDrawSw_Response {
    void call(
        SyncCompositorCommonRendererParams syncCompositorCommonRendererParams,
        int i,
        CompositorFrameMetadata compositorFrameMetadata);
  }

  public interface Proxy extends SynchronousCompositor, Interface.Proxy {}

  public interface SetSharedMemory_Response {
    void call(boolean z, SyncCompositorCommonRendererParams syncCompositorCommonRendererParams);
  }

  public interface ZoomBy_Response {
    void call(SyncCompositorCommonRendererParams syncCompositorCommonRendererParams);
  }

  void beginFrame(BeginFrameArgs beginFrameArgs, Map<Integer, FrameTimingDetails> map);

  void demandDrawHw(
      SyncCompositorDemandDrawHwParams syncCompositorDemandDrawHwParams,
      DemandDrawHw_Response demandDrawHw_Response);

  void demandDrawHwAsync(SyncCompositorDemandDrawHwParams syncCompositorDemandDrawHwParams);

  void demandDrawSw(
      SyncCompositorDemandDrawSwParams syncCompositorDemandDrawSwParams,
      DemandDrawSw_Response demandDrawSw_Response);

  void onCompositorFrameTransitionDirectiveProcessed(int i, int i2);

  void reclaimResources(int i, ReturnedResource[] returnedResourceArr);

  void setBeginFrameSourcePaused(boolean z);

  void setMemoryPolicy(int i);

  void setScroll(PointF pointF);

  void setSharedMemory(
      WritableSharedMemoryRegion writableSharedMemoryRegion,
      SetSharedMemory_Response setSharedMemory_Response);

  void willSkipDraw();

  void zeroSharedMemory();

  void zoomBy(float f, Point point, ZoomBy_Response zoomBy_Response);
}
