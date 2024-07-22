package org.chromium.blink.mojom;

import org.chromium.cc.mojom.RenderFrameMetadata;
import org.chromium.gfx.mojom.RectF;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.viz.mojom.FrameSinkId;

public interface RemoteFrame extends Interface {
  public static final Interface.Manager<RemoteFrame, Proxy> MANAGER = RemoteFrame_Internal.MANAGER;

  public interface Proxy extends RemoteFrame, Interface.Proxy {}

  void addResourceTimingFromChild(ResourceTimingInfo resourceTimingInfo);

  void bubbleLogicalScroll(int i, int i2);

  void childProcessGone();

  void collapse(boolean z);

  void createRemoteChild(
      RemoteFrameToken remoteFrameToken,
      FrameToken frameToken,
      int i,
      FrameReplicationState frameReplicationState,
      FrameOwnerProperties frameOwnerProperties,
      boolean z,
      UnguessableToken unguessableToken,
      RemoteFrameInterfacesFromBrowser remoteFrameInterfacesFromBrowser);

  void createRemoteChildren(CreateRemoteChildParams[] createRemoteChildParamsArr);

  void detachAndDispose();

  void didSetFramePolicyHeaders(
      int i, ParsedPermissionsPolicyDeclaration[] parsedPermissionsPolicyDeclarationArr);

  void didStartLoading();

  void didStopLoading();

  void didUpdateFramePolicy(FramePolicy framePolicy);

  void didUpdateVisualProperties(RenderFrameMetadata renderFrameMetadata);

  void disableAutoResize();

  void dispatchLoadEventForFrameOwner();

  void enableAutoResize(Size size, Size size2);

  void enforceInsecureNavigationsSet(int[] iArr);

  void enforceInsecureRequestPolicy(int i);

  void focus();

  void intrinsicSizingInfoOfChildChanged(IntrinsicSizingInfo intrinsicSizingInfo);

  void renderFallbackContent();

  void scrollRectToVisible(RectF rectF, ScrollIntoViewParams scrollIntoViewParams);

  void setEmbeddingToken(UnguessableToken unguessableToken);

  void setFrameOwnerProperties(FrameOwnerProperties frameOwnerProperties);

  void setFrameSinkId(FrameSinkId frameSinkId);

  void setHadStickyUserActivationBeforeNavigation(boolean z);

  void setNeedsOcclusionTracking(boolean z);

  void setPageFocus(boolean z);

  void setReplicatedIsAdFrame(boolean z);

  void setReplicatedName(String str, String str2);

  void setReplicatedOrigin(Origin origin, boolean z);

  void updateOpener(FrameToken frameToken);

  void updateUserActivationState(int i, int i2);

  void willEnterFullscreen(FullscreenOptions fullscreenOptions);
}
