package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Range;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.ui.mojom.ImeTextSpan;
import org.chromium.ui.mojom.LatencyInfo;

public interface WidgetInputHandler extends Interface {
  public static final Interface.Manager<WidgetInputHandler, Proxy> MANAGER =
      WidgetInputHandler_Internal.MANAGER;

  public interface DispatchEvent_Response {
    void call(
        int i,
        LatencyInfo latencyInfo,
        int i2,
        DidOverscrollParams didOverscrollParams,
        TouchActionOptional touchActionOptional);
  }

  public interface ImeCommitText_Response {
    void call();
  }

  public interface ImeSetComposition_Response {
    void call();
  }

  public interface Proxy extends WidgetInputHandler, Interface.Proxy {}

  public interface WaitForInputProcessed_Response {
    void call();
  }

  void attachSynchronousCompositor(
      SynchronousCompositorControlHost synchronousCompositorControlHost,
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported);

  void cursorVisibilityChanged(boolean z);

  void dispatchEvent(Event event, DispatchEvent_Response dispatchEvent_Response);

  void dispatchNonBlockingEvent(Event event);

  void getFrameWidgetInputHandler(
      AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported);

  void imeCommitText(
      String16 string16,
      ImeTextSpan[] imeTextSpanArr,
      Range range,
      int i,
      ImeCommitText_Response imeCommitText_Response);

  void imeFinishComposingText(boolean z);

  void imeSetComposition(
      String16 string16,
      ImeTextSpan[] imeTextSpanArr,
      Range range,
      int i,
      int i2,
      ImeSetComposition_Response imeSetComposition_Response);

  void mouseCaptureLost();

  void requestCompositionUpdates(boolean z, boolean z2);

  void requestTextInputStateUpdate();

  void setEditCommandsForNextKeyEvent(EditCommand[] editCommandArr);

  void setFocus(int i);

  void updateBrowserControlsState(int i, int i2, boolean z);

  void waitForInputProcessed(WaitForInputProcessed_Response waitForInputProcessed_Response);
}
