package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface RendererPreferenceWatcher extends Interface {
  public static final Interface.Manager<RendererPreferenceWatcher, Proxy> MANAGER =
      RendererPreferenceWatcher_Internal.MANAGER;

  public interface Proxy extends RendererPreferenceWatcher, Interface.Proxy {}

  void notifyUpdate(RendererPreferences rendererPreferences);
}
