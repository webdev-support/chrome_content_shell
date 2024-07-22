package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AudioFocusRequestClient extends Interface {
  public static final Interface.Manager<AudioFocusRequestClient, Proxy> MANAGER =
      AudioFocusRequestClient_Internal.MANAGER;

  public interface Proxy extends AudioFocusRequestClient, Interface.Proxy {}

  public interface RequestAudioFocus_Response {
    void call();
  }

  void abandonAudioFocus();

  void mediaSessionInfoChanged(MediaSessionInfo mediaSessionInfo);

  void requestAudioFocus(
      MediaSessionInfo mediaSessionInfo,
      int i,
      RequestAudioFocus_Response requestAudioFocus_Response);
}
