package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface MediaControllerManager extends Interface {
  public static final Interface.Manager<MediaControllerManager, Proxy> MANAGER =
      MediaControllerManager_Internal.MANAGER;

  public interface Proxy extends MediaControllerManager, Interface.Proxy {}

  void createActiveMediaController(InterfaceRequest<MediaController> interfaceRequest);

  void createMediaControllerForSession(
      InterfaceRequest<MediaController> interfaceRequest, UnguessableToken unguessableToken);

  void suspendAllSessions();
}
