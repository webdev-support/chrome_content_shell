package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Range;
import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.Interface;

public interface WidgetInputHandlerHost extends Interface {
  public static final Interface.Manager<WidgetInputHandlerHost, Proxy> MANAGER =
      WidgetInputHandlerHost_Internal.MANAGER;

  public interface Proxy extends WidgetInputHandlerHost, Interface.Proxy {}

  public interface RequestMouseLock_Response {
    void call(int i, PointerLockContext pointerLockContext);
  }

  void didOverscroll(DidOverscrollParams didOverscrollParams);

  void didStartScrollingViewport();

  void imeCancelComposition();

  void imeCompositionRangeChanged(Range range, Rect[] rectArr, Rect[] rectArr2);

  void requestMouseLock(boolean z, boolean z2, RequestMouseLock_Response requestMouseLock_Response);

  void setAutoscrollSelectionActiveInMainFrame(boolean z);

  void setMouseCapture(boolean z);

  void setPanAction(int i);

  void setTouchActionFromMain(int i);
}
