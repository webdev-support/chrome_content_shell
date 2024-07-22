package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface FlingingRendererClientExtension extends Interface {
  public static final Interface.Manager<FlingingRendererClientExtension, Proxy> MANAGER =
      FlingingRendererClientExtension_Internal.MANAGER;

  public interface Proxy extends FlingingRendererClientExtension, Interface.Proxy {}

  void onRemotePlayStateChange(int i);
}
