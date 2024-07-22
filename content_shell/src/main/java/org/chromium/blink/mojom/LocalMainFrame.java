package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;
import org.chromium.network.mojom.CrossOriginOpenerPolicyReporterParams;

public interface LocalMainFrame extends Interface {
  public static final Interface.Manager<LocalMainFrame, Proxy> MANAGER =
      LocalMainFrame_Internal.MANAGER;

  public interface ClosePage_Response {
    void call();
  }

  public interface GetFullPageSize_Response {
    void call(Size size);
  }

  public interface Proxy extends LocalMainFrame, Interface.Proxy {}

  void animateDoubleTapZoom(Point point, Rect rect);

  void closePage(ClosePage_Response closePage_Response);

  void enablePreferredSizeChangedMode();

  void getFullPageSize(GetFullPageSize_Response getFullPageSize_Response);

  void installCoopAccessMonitor(
      FrameToken frameToken,
      CrossOriginOpenerPolicyReporterParams crossOriginOpenerPolicyReporterParams,
      boolean z);

  void setInitialFocus(boolean z);

  void setScaleFactor(float f);

  void setV8CompileHints(ReadOnlySharedMemoryRegion readOnlySharedMemoryRegion);

  void updateBrowserControlsState(int i, int i2, boolean z);

  void zoomToFindInPageRect(Rect rect);
}
