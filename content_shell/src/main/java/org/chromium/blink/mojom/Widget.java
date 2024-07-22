package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface Widget extends Interface {
  public static final Interface.Manager<Widget, Proxy> MANAGER = Widget_Internal.MANAGER;

  public interface ForceRedraw_Response {
    void call();
  }

  public interface Proxy extends Widget, Interface.Proxy {}

  public interface UpdateScreenRects_Response {
    void call();
  }

  void cancelSuccessfulPresentationTimeRequest();

  void forceRedraw(ForceRedraw_Response forceRedraw_Response);

  void getWidgetInputHandler(
      InterfaceRequest<WidgetInputHandler> interfaceRequest,
      WidgetInputHandlerHost widgetInputHandlerHost);

  void requestSuccessfulPresentationTimeForNextFrame(
      RecordContentToVisibleTimeRequest recordContentToVisibleTimeRequest);

  void updateScreenRects(
      Rect rect, Rect rect2, UpdateScreenRects_Response updateScreenRects_Response);

  void updateVisualProperties(VisualProperties visualProperties);

  void wasHidden();

  void wasShown(boolean z, RecordContentToVisibleTimeRequest recordContentToVisibleTimeRequest);
}
