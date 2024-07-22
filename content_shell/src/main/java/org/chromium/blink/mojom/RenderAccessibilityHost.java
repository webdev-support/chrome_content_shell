package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface RenderAccessibilityHost extends Interface {
  public static final Interface.Manager<RenderAccessibilityHost, Proxy> MANAGER =
      RenderAccessibilityHost_Internal.MANAGER;

  public interface HandleAxEvents_Response {
    void call();
  }

  public interface Proxy extends RenderAccessibilityHost, Interface.Proxy {}

  void handleAxEvents(
      AxUpdatesAndEvents axUpdatesAndEvents,
      int i,
      HandleAxEvents_Response handleAxEvents_Response);

  void handleAxLocationChanges(LocationChanges[] locationChangesArr, int i);
}
