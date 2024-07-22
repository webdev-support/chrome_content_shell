package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.skia.mojom.SkColor;

public interface PageBroadcast extends Interface {
  public static final Interface.Manager<PageBroadcast, Proxy> MANAGER =
      PageBroadcast_Internal.MANAGER;

  public interface ActivatePrerenderedPage_Response {
    void call();
  }

  public interface Proxy extends PageBroadcast, Interface.Proxy {}

  public interface SetPageLifecycleState_Response {
    void call();
  }

  void activatePrerenderedPage(
      PrerenderPageActivationParams prerenderPageActivationParams,
      ActivatePrerenderedPage_Response activatePrerenderedPage_Response);

  void audioStateChanged(boolean z);

  void createRemoteMainFrame(
      RemoteFrameToken remoteFrameToken,
      FrameToken frameToken,
      FrameReplicationState frameReplicationState,
      boolean z,
      UnguessableToken unguessableToken,
      RemoteFrameInterfacesFromBrowser remoteFrameInterfacesFromBrowser,
      RemoteMainFrameInterfaces remoteMainFrameInterfaces);

  void setHistoryOffsetAndLength(int i, int i2);

  void setPageAttributionSupport(int i);

  void setPageBaseBackgroundColor(SkColor skColor);

  void setPageLifecycleState(
      PageLifecycleState pageLifecycleState,
      PageRestoreParams pageRestoreParams,
      SetPageLifecycleState_Response setPageLifecycleState_Response);

  void updateColorProviders(ColorProviderColorMaps colorProviderColorMaps);

  void updatePageBrowsingContextGroup(BrowsingContextGroupInfo browsingContextGroupInfo);

  void updateRendererPreferences(RendererPreferences rendererPreferences);

  void updateWebPreferences(WebPreferences webPreferences);
}
