package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface MediaFoundationRendererObserver extends Interface {
  public static final Interface.Manager<MediaFoundationRendererObserver, Proxy> MANAGER =
      MediaFoundationRendererObserver_Internal.MANAGER;

  public interface Proxy extends MediaFoundationRendererObserver, Interface.Proxy {}
}
