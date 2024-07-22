package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface AudioFocusManagerDebug extends Interface {
  public static final Interface.Manager<AudioFocusManagerDebug, Proxy> MANAGER =
      AudioFocusManagerDebug_Internal.MANAGER;

  public interface GetDebugInfoForRequest_Response {
    void call(MediaSessionDebugInfo mediaSessionDebugInfo);
  }

  public interface Proxy extends AudioFocusManagerDebug, Interface.Proxy {}

  void getDebugInfoForRequest(
      UnguessableToken unguessableToken,
      GetDebugInfoForRequest_Response getDebugInfoForRequest_Response);
}
