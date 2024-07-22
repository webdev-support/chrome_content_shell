package org.chromium.viz.mojom;

import org.chromium.gpu.mojom.Mailbox;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;

public interface FrameSinkBundle extends Interface {
  public static final Interface.Manager<FrameSinkBundle, Proxy> MANAGER =
      FrameSinkBundle_Internal.MANAGER;

  public interface Proxy extends FrameSinkBundle, Interface.Proxy {}

  void didAllocateSharedBitmap(
      int i, ReadOnlySharedMemoryRegion readOnlySharedMemoryRegion, Mailbox mailbox);

  void initializeCompositorFrameSinkType(int i, int i2);

  void setNeedsBeginFrame(int i, boolean z);

  void setThreadIds(int i, int[] iArr);

  void setWantsBeginFrameAcks(int i);

  void submit(BundledFrameSubmission[] bundledFrameSubmissionArr);
}
