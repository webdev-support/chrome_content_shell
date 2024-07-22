package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface MediaFoundationRendererNotifier extends Interface {
  public static final Interface.Manager<MediaFoundationRendererNotifier, Proxy> MANAGER =
      MediaFoundationRendererNotifier_Internal.MANAGER;

  public interface Proxy extends MediaFoundationRendererNotifier, Interface.Proxy {}

  void mediaFoundationRendererCreated(
      InterfaceRequest<MediaFoundationRendererObserver> interfaceRequest);
}
