package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface RemoteFrameHost extends Interface {
  public static final Interface.Manager<RemoteFrameHost, Proxy> MANAGER =
      RemoteFrameHost_Internal.MANAGER;

  public interface Proxy extends RemoteFrameHost, Interface.Proxy {}

  void advanceFocus(int i, LocalFrameToken localFrameToken);

  void capturePaintPreviewOfCrossProcessSubframe(Rect rect, UnguessableToken unguessableToken);

  void checkCompleted();

  void detach();

  void didChangeOpener(LocalFrameToken localFrameToken);

  void didFocusFrame();

  void openUrl(OpenUrlParams openUrlParams);

  void printCrossProcessSubframe(Rect rect, int i);

  void routeMessageEvent(
      LocalFrameToken localFrameToken,
      String16 string16,
      String16 string162,
      TransferableMessage transferableMessage);

  void setInheritedEffectiveTouchAction(int i);

  void setIsInert(boolean z);

  void synchronizeVisualProperties(FrameVisualProperties frameVisualProperties);

  void updateRenderThrottlingStatus(boolean z, boolean z2, boolean z3);

  void updateViewportIntersection(
      ViewportIntersectionState viewportIntersectionState,
      FrameVisualProperties frameVisualProperties);

  void visibilityChanged(int i);
}
