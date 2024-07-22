package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Vector2dF;
import org.chromium.mojo.bindings.Interface;

public interface FrameWidgetHost extends Interface {
  public static final Interface.Manager<FrameWidgetHost, Proxy> MANAGER =
      FrameWidgetHost_Internal.MANAGER;

  public interface Proxy extends FrameWidgetHost, Interface.Proxy {}

  void animateDoubleTapZoomInMainFrame(Point point, Rect rect);

  void autoscrollEnd();

  void autoscrollFling(Vector2dF vector2dF);

  void autoscrollStart(PointF pointF);

  void intrinsicSizingInfoChanged(IntrinsicSizingInfo intrinsicSizingInfo);

  void setHasTouchEventConsumers(TouchEventConsumers touchEventConsumers);

  void zoomToFindInPageRectInMainFrame(Rect rect);
}
