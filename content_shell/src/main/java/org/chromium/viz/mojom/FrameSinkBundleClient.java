package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.Interface;

public interface FrameSinkBundleClient extends Interface {
  public static final Interface.Manager<FrameSinkBundleClient, Proxy> MANAGER =
      FrameSinkBundleClient_Internal.MANAGER;

  public interface Proxy extends FrameSinkBundleClient, Interface.Proxy {}

  void flushNotifications(
      BundledReturnedResources[] bundledReturnedResourcesArr,
      BeginFrameInfo[] beginFrameInfoArr,
      BundledReturnedResources[] bundledReturnedResourcesArr2);

  void onBeginFramePausedChanged(int i, boolean z);

  void onCompositorFrameTransitionDirectiveProcessed(int i, int i2);
}
