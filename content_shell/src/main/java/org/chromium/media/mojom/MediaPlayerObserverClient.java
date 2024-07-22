package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface MediaPlayerObserverClient extends Interface {
  public static final Interface.Manager<MediaPlayerObserverClient, Proxy> MANAGER =
      MediaPlayerObserverClient_Internal.MANAGER;

  public interface GetHasPlayedBefore_Response {
    void call(boolean z);
  }

  public interface Proxy extends MediaPlayerObserverClient, Interface.Proxy {}

  void getHasPlayedBefore(GetHasPlayedBefore_Response getHasPlayedBefore_Response);
}
