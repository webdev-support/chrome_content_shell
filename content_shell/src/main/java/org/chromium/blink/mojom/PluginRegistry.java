package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PluginRegistry extends Interface {
  public static final Interface.Manager<PluginRegistry, Proxy> MANAGER =
      PluginRegistry_Internal.MANAGER;

  public interface GetPlugins_Response {
    void call(PluginInfo[] pluginInfoArr);
  }

  public interface Proxy extends PluginRegistry, Interface.Proxy {}

  void getPlugins(boolean z, GetPlugins_Response getPlugins_Response);
}
