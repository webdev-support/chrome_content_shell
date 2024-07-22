package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface WidgetCompositor extends Interface {
  public static final Interface.Manager<WidgetCompositor, Proxy> MANAGER =
      WidgetCompositor_Internal.MANAGER;

  public interface Proxy extends WidgetCompositor, Interface.Proxy {}

  public interface VisualStateRequest_Response {
    void call();
  }

  void visualStateRequest(VisualStateRequest_Response visualStateRequest_Response);
}
