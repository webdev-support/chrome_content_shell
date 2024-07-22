package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.viz.mojom.InputTargetClient;

public interface FrameWidget extends Interface {
  public static final Interface.Manager<FrameWidget, Proxy> MANAGER = FrameWidget_Internal.MANAGER;

  public interface DragSourceEndedAt_Response {
    void call();
  }

  public interface DragTargetDragEnter_Response {
    void call(int i, boolean z);
  }

  public interface DragTargetDragOver_Response {
    void call(int i, boolean z);
  }

  public interface DragTargetDrop_Response {
    void call();
  }

  public interface OnStartStylusWriting_Response {
    void call(Rect rect, Rect rect2);
  }

  public interface Proxy extends FrameWidget, Interface.Proxy {}

  void bindInputTargetClient(InterfaceRequest<InputTargetClient> interfaceRequest);

  void bindWidgetCompositor(InterfaceRequest<WidgetCompositor> interfaceRequest);

  void disableDeviceEmulation();

  void dragSourceEndedAt(
      PointF pointF, PointF pointF2, int i, DragSourceEndedAt_Response dragSourceEndedAt_Response);

  void dragSourceSystemDragEnded();

  void dragTargetDragEnter(
      DragData dragData,
      PointF pointF,
      PointF pointF2,
      AllowedDragOperations allowedDragOperations,
      int i,
      DragTargetDragEnter_Response dragTargetDragEnter_Response);

  void dragTargetDragLeave(PointF pointF, PointF pointF2);

  void dragTargetDragOver(
      PointF pointF,
      PointF pointF2,
      AllowedDragOperations allowedDragOperations,
      int i,
      DragTargetDragOver_Response dragTargetDragOver_Response);

  void dragTargetDrop(
      DragData dragData,
      PointF pointF,
      PointF pointF2,
      int i,
      DragTargetDrop_Response dragTargetDrop_Response);

  void enableDeviceEmulation(DeviceEmulationParams deviceEmulationParams);

  void onStartStylusWriting(OnStartStylusWriting_Response onStartStylusWriting_Response);

  void setActive(boolean z);

  void setBackgroundOpaque(boolean z);

  void setInheritedEffectiveTouchActionForSubFrame(int i);

  void setIsInertForSubFrame(boolean z);

  void setTextDirection(int i);

  void setViewportIntersection(
      ViewportIntersectionState viewportIntersectionState, VisualProperties visualProperties);

  void showContextMenu(int i, Point point);

  void updateRenderThrottlingStatusForSubFrame(boolean z, boolean z2, boolean z3);
}
