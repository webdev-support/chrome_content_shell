package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface MediaPlayerRendererExtension extends Interface {
  public static final Interface.Manager<MediaPlayerRendererExtension, Proxy> MANAGER =
      MediaPlayerRendererExtension_Internal.MANAGER;

  public interface InitiateScopedSurfaceRequest_Response {
    void call(UnguessableToken unguessableToken);
  }

  public interface Proxy extends MediaPlayerRendererExtension, Interface.Proxy {}

  void initiateScopedSurfaceRequest(
      InitiateScopedSurfaceRequest_Response initiateScopedSurfaceRequest_Response);
}
