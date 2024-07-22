package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface RemoteMainFrameHost extends Interface {
  public static final Interface.Manager<RemoteMainFrameHost, Proxy> MANAGER =
      RemoteMainFrameHost_Internal.MANAGER;

  public interface Proxy extends RemoteMainFrameHost, Interface.Proxy {}

  public interface UpdateTargetUrl_Response {
    void call();
  }

  void focusPage();

  void routeCloseEvent();

  void takeFocus(boolean z);

  void updateTargetUrl(Url url, UpdateTargetUrl_Response updateTargetUrl_Response);
}
