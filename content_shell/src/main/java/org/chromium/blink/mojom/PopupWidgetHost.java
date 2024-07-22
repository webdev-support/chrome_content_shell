package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.Interface;

public interface PopupWidgetHost extends Interface {
  public static final Interface.Manager<PopupWidgetHost, Proxy> MANAGER =
      PopupWidgetHost_Internal.MANAGER;

  public interface Proxy extends PopupWidgetHost, Interface.Proxy {}

  public interface SetPopupBounds_Response {
    void call();
  }

  public interface ShowPopup_Response {
    void call();
  }

  void requestClosePopup();

  void setPopupBounds(Rect rect, SetPopupBounds_Response setPopupBounds_Response);

  void showPopup(Rect rect, Rect rect2, ShowPopup_Response showPopup_Response);
}
